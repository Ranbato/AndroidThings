package com.example.myapplication.services

import android.graphics.Color
import android.util.Log
import com.google.android.things.contrib.driver.ht16k33.AlphanumericDisplay
import com.google.android.things.contrib.driver.rainbowhat.RainbowHat
import java.io.IOException
import java.util.*

class LEDScrollerService {
    private val display: AlphanumericDisplay = RainbowHat.openDisplay()
    private var timer = Timer()

    private var marqueeData = MarqueeGenerator(" ".toCharArray().toTypedArray(),' ',0)
//    private var marqueeData = MarqueeGenerator(
//        "Hello World. My name is Mark Lambert".toCharArray().toTypedArray(),
//        ' ' ,
//        3
//    )

    public fun enableDisplay(value: Boolean): Unit {
        display.setEnabled(value)
        display.clear()
        if (value) {
            timer.cancel() // Multiple cancels are OK
            timer = Timer()
            timer.scheduleAtFixedRate(MarqueeTimerTask() , 0, 200)
        } else {
            timer.cancel()
        }

    }

    public fun updateDisplay(value: String) {
        try {
            marqueeData = MarqueeGenerator(value.toCharArray().toTypedArray(),' ',3)
        } catch (e: IOException) {
//                Log.e(TAG, "Error setting display", e)
        }
    }




    private inner class MarqueeTimerTask: TimerTask() {

        private fun join(arr: ArrayList<String>): String {
            val strBuilder = StringBuilder(arr.size)
            for (i in arr.indices) {
                strBuilder.append(arr[i])
            }
            return strBuilder.toString()
        }

        override fun run() {
            try {
                display.display((marqueeData.next(6).joinToString("") ))
            } catch (e: IOException) {
//            Log.e(TAG, "Unable to set display.", e)
            }
        }
    }
}
 class MarqueeGenerator<T> internal constructor(seedValues: Array<T>, private val emptyVal: T, prefixSize: Int) {
    private var start = 0

    private val values: ArrayList<T>

    private fun getEmptyArray(size: Int, emptyVal: T): ArrayList<T> {
        val response = ArrayList<T>(size + 1)
        for (i in 0 until size) {
            response.add(i, emptyVal)
        }
        return response
    }

    init {
        this.values = getEmptyArray(seedValues.size + prefixSize, emptyVal)
        for (i in seedValues.indices) {
            this.values[prefixSize + i] = seedValues[i]
        }
    }

    internal fun next(read: Int): ArrayList<T> {
//        Log.d(TAG, "Marquee Generator next() invoked")
        val response = getEmptyArray(read, this.emptyVal)
        val size = values.size
        if (start >= size) {
            start = 0
            return response
        }
        for (i in 0 until read) {
            response[i] = if (start + i < size) values[start + i] else emptyVal
        }
        start++
        return response
    }

}

