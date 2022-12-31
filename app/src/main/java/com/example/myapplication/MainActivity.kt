package com.example.myapplication

import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.KeyEvent
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R.id.nav_host_fragment_content_main
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.services.LEDScrollerService
import com.example.myapplication.services.PasswordUpdater
import com.google.android.things.contrib.driver.bmx280.Bmx280SensorDriver
import com.google.android.things.contrib.driver.rainbowhat.RainbowHat
import com.google.android.things.pio.Gpio
import kotlinx.coroutines.*
import java.io.IOException
import java.math.RoundingMode
import java.text.DecimalFormat


/**
 *
 *  Some resources
 *  https://github.com/ssieb/custom_components/blob/master/components/ht16k33_alpha/font.h
 *  https://github.com/ssieb/custom_components/blob/master/components/ht16k33_alpha/ht16k33_display.cpp
 *  https://github.com/foush/android-things-hello-world/blob/master/app/src/main/java/com/johnfoushee/androidthings/helloworld/HelloWorldActivity.kt
 *
 *
 *
 */

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sensorManager: SensorManager
    private lateinit var redLED: Gpio
    private lateinit var greenLED: Gpio
    private lateinit var blueLED: Gpio
    private val unifi = PasswordUpdater()
    private val wifiFragment = GuestWifiFragment()
    private val weatherFragment = WeatherFragment()
    private val display = LEDScrollerService()
    private val rainbowLEDs = IntArray(7)

    private val LEDSTRIP_BRIGHTNESS = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        lifecycleScope.async {
            // generate initial QR code on a separate coroutine.
            val jobs = listOf(async(Dispatchers.IO) { unifi.getWifiQRCode() },

                async(Dispatchers.Main) {
                    binding = ActivityMainBinding.inflate(layoutInflater)
                    setContentView(binding.root)

                    try {
                        // Sensors
                        val environmentalSensorDriver = Bmx280SensorDriver("I2C1")
                        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
                        sensorManager.registerDynamicSensorCallback(dynamicSensorCallback)
                        environmentalSensorDriver.registerTemperatureSensor()
//                        environmentalSensorDriver.registerPressureSensor()
//                        environmentalSensorDriver.registerHumiditySensor()



                        // Buttons
                        val aButtonInputDriver = RainbowHat.createButtonAInputDriver(KeyEvent.KEYCODE_A)
                        aButtonInputDriver.register()
                        val bButtonInputDriver = RainbowHat.createButtonBInputDriver(KeyEvent.KEYCODE_B)
                        bButtonInputDriver.register()
                        val cButtonInputDriver = RainbowHat.createButtonCInputDriver(KeyEvent.KEYCODE_C)
                        cButtonInputDriver.register()

                        // Button LEDs
                        redLED = RainbowHat.openLedRed()
                        redLED.value = false
                        greenLED = RainbowHat.openLedGreen()
                        greenLED.value = false
                        blueLED = RainbowHat.openLedBlue()
                        blueLED.value = false

                        // Rainbow LEDs
                        val mLedstrip = RainbowHat.openLedStrip()
                        mLedstrip.setBrightness(LEDSTRIP_BRIGHTNESS)
                        for (i in rainbowLEDs.indices) {
                            val hsv = floatArrayOf(i * 360f / rainbowLEDs.size, 1.0f, 1.0f)
                            rainbowLEDs[i] = Color.HSVToColor(255, hsv)
                        }
                        mLedstrip.write(rainbowLEDs)
                    } catch (e: IOException) {
                        throw RuntimeException("Error initializing GPIO button", e)
                    }
                })
            jobs.awaitAll()
        }


    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean = runBlocking {

        // Cleanup
        display.enableDisplay(false)

        return@runBlocking when (keyCode) {

            KeyEvent.KEYCODE_A -> {
                val fragmentmanager = supportFragmentManager
                fragmentmanager.commit {

                    replace(nav_host_fragment_content_main, wifiFragment)

                    val view = binding.root.rootView
                    view.findViewById<ImageView>(R.id.QRCode).setImageBitmap(unifi.getWifiQRCode())
                    view.findViewById<TextView>(R.id.wifiSSID).text = unifi.getNetworkSSID()
                    view.findViewById<TextView>(R.id.wifiPassword).text = unifi.getNetworkPassword()

                }
                redLED.value = true
                greenLED.value = false
                blueLED.value = false

                true
            }

            KeyEvent.KEYCODE_B -> {
                val fragmentmanager = supportFragmentManager
                fragmentmanager.commit {
                    replace(nav_host_fragment_content_main, weatherFragment)
                }
                redLED.value = false
                greenLED.value = true
                blueLED.value = false

                display.enableDisplay(true)
                display.updateDisplay("Hello from Mark Lambert!")
                true
            }

            KeyEvent.KEYCODE_C -> {
                val fragmentmanager = supportFragmentManager
                fragmentmanager.commit {
                    replace(nav_host_fragment_content_main, SecondFragment())
                }
                redLED.value = false
                greenLED.value = false
                blueLED.value = true
                true
            }

            else -> super.onKeyUp(keyCode, event)
        }
    }

    // Callback used when we register the BMP280 sensor driver with the system's SensorManager.
    private val dynamicSensorCallback: SensorManager.DynamicSensorCallback =
        object : SensorManager.DynamicSensorCallback() {
            override fun onDynamicSensorConnected(sensor: Sensor) {
                if (sensor.type == Sensor.TYPE_AMBIENT_TEMPERATURE) {
                    // Our sensor is connected. Start receiving temperature data.
                    sensorManager.registerListener(
                        temperatureListener, sensor,
                        SensorManager.SENSOR_DELAY_NORMAL
                    )
                } else if (sensor.type == Sensor.TYPE_PRESSURE) {
                    // Our sensor is connected. Start receiving pressure data.
                    sensorManager.registerListener(
                        pressureListener, sensor,
                        SensorManager.SENSOR_DELAY_NORMAL
                    )
                }
            }

            override fun onDynamicSensorDisconnected(sensor: Sensor) {
                super.onDynamicSensorDisconnected(sensor)
            }
        }


    // Callback when SensorManager delivers temperature data.
    private val temperatureListener: SensorEventListener = object : SensorEventListener {
        override fun onSensorChanged(event: SensorEvent) {
            val lastTemperature = event.values[0]
//            Log.d(TAG, "sensor changed: $mLastTemperature")
            val fragmentmanager = supportFragmentManager
            fragmentmanager.commit {

                val view = binding.root.rootView
                val df = DecimalFormat("0.00")
                df.roundingMode = RoundingMode.HALF_UP
                val rounded = df.format((lastTemperature*9/5)+32)
                view.findViewById<TextView>(R.id.temperature)?.text = getString(R.string.default_temp_value, rounded.toString())

            }
        }

        override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
//            Log.d(TAG, "accuracy changed: $accuracy")
        }
    }

    // Callback when SensorManager delivers pressure data.
    private val pressureListener: SensorEventListener = object : SensorEventListener {
        override fun onSensorChanged(event: SensorEvent) {
//            val mLastPressure = event.values[0]
////            Log.d(TAG, "sensor changed: $mLastPressure")
//                updateDisplay(mLastPressure)
//            }
//            updateBarometer(mLastPressure)
        }

        override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
//            Log.d(TAG, "accuracy changed: $accuracy")
        }
    }
}

