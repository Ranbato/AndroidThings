package com.example.myapplication.services

import android.graphics.Bitmap
import android.util.Log
import com.example.myapplication.BuildConfig
import com.example.myapplication.clients.UnsafeOkHttpClient
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.lambertland.kotlin.unifiapi.generated.model.Sites
import org.lambertland.kotlin.unifiapi.generated.model.WlanConfs
import java.util.*
import javax.net.ssl.*
import kotlin.collections.HashMap
import kotlin.collections.List
import kotlin.random.Random

// Constants
const val WHITE = -0x1
const val BLACK = -0x1000000

const val wifiSSID = "Bespin Guest"
const val TAG = "PasswordUpdater"

class PasswordUpdater {

    private var networkPassword = ""
    private var qrBitmap: Bitmap? = null

    fun generatePassword(length: Int): String {

        val password = CharArray(length)

        var index = 0

        while (index < length) {
            // 33 - 126 is the ascii range of characters that don't give most text fields many problems
            val nextChar = Random.nextInt(33, 127)
            // 34 is ", 37 is %, 44 is ,, 59 is ; - these sometimes give password fields trouble
            if (nextChar == 34 || nextChar == 37 || nextChar == 44 || nextChar == 59) {
                continue
            }
            password[index++] = nextChar.toChar()
        }
        return password.concatToString()
    }

    @Throws(WriterException::class)
    fun encodeAsBitmap(
        contents: String,
        format: BarcodeFormat,
        desiredWidth: Int,
        desiredHeight: Int
    ): Bitmap {

        val hints: Hashtable<EncodeHintType, Any> = Hashtable<EncodeHintType, Any>(2)
        hints[EncodeHintType.CHARACTER_SET] = "UTF-8"
        val writer = MultiFormatWriter()
        val result: BitMatrix = writer.encode(contents, format, desiredWidth, desiredHeight, hints)
        val width: Int = result.width
        val height: Int = result.height
        val pixels = IntArray(width * height)
        // All are 0, or black, by default
        for (y in 0 until height) {
            val offset = y * width
            for (x in 0 until width) {
                pixels[offset + x] =
                    if (result.get(x, y)) BLACK else WHITE
            }
        }
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height)
        return bitmap
    }

    private fun generateQRCode(
        wifiSSID: String,
        wifiPassword: String,
        encryption: String = "",
        hidden: Boolean = false,
        width: Int = 150,
        height: Int = 150
    ): Bitmap? {

        // this is a small sample use of the QRCodeEncoder class from zxing
        try {
            // generate a 150x150 QR code
            // WIFI:S:<SSID>;T:<WEP|WPA|blank>;P:<PASSWORD>;H:<true|false|blank>;;
            return encodeAsBitmap(
                "WIFI:S:${wifiSSID};T:$encryption;P:$wifiPassword;H:$hidden;;",
                BarcodeFormat.QR_CODE,
                width,
                height
            )

        } catch (e: WriterException) { //eek
        }
        return null
    }

    suspend fun getWifiQRCode(): Bitmap? {
        try {
            if (qrBitmap == null) {
                getNetworkPassword()
                Log.d(TAG, "Generating QR code for $wifiSSID")
                qrBitmap = generateQRCode(wifiSSID, networkPassword, "WPA")
            }
        }catch (e:Exception ){
            Log.d(TAG,"Exception $e")
        }
        return qrBitmap


    }

    suspend fun authenticateToWifi(): OkHttpClient? {
        // Move the execution of the coroutine to the I/O dispatcher
        return withContext(Dispatchers.IO) {

            // Blocking network request code
            val administrationUsername = BuildConfig.wifi_user
            val administrationPassword = BuildConfig.wifi_password

            val basepath = "https://${BuildConfig.wifi_host}"
            val authEndpoint = "$basepath/api/login"

            // OKHttp
            val client = with(UnsafeOkHttpClient.getUnsafeOkHttpClientBuilder()) {
                cookieJar(object : CookieJar {
                    val cookieStore: HashMap<String, List<Cookie>> = HashMap()
                    override fun loadForRequest(url: HttpUrl): List<Cookie> {
                        return cookieStore[url.host].orEmpty()
                    }

                    override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
                        cookieStore[url.host] = cookies
                    }

                })
            }.build()
            val loginBody =
                """{"username": "$administrationUsername", "password": "$administrationPassword"}""".toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())

            val loginRequest = with(Request.Builder()) {
                url(authEndpoint)
                addHeader("Accept", "application/json")
                addHeader("Content-type", "application/json")
                post(loginBody)
            }.build()

            Log.d(TAG,"Logging in")
            val loginResponse = client.newCall(loginRequest).execute()

            if (loginResponse.code != 200) {
                Log.d(TAG,"Problem logging in to the network controller")
                return@withContext null
            }
            Log.d(TAG,"Logged in to controller")
            return@withContext client
        }

    }

    fun getNetworkSSID(): String {
        return wifiSSID
    }

    //https://github.com/kmanc/wifi_qr/blob/master/update_wifi.py
    @OptIn(ExperimentalSerializationApi::class)
    suspend fun getNetworkPassword(): String {

        if (networkPassword.isNotEmpty()) return networkPassword

        // Move the execution of the coroutine to the I/O dispatcher
        return withContext(Dispatchers.IO) {

            Log.d(TAG, "authenticating")
            val client = authenticateToWifi() ?: return@withContext "Unknown!!"

            Log.d(TAG, "got client")
            val basepath = "https://${BuildConfig.wifi_host}"

            val sitesEndpoint = "$basepath/api/stat/sites"
            val sitesRequest = with(Request.Builder()) {
                url(sitesEndpoint)
                addHeader("Accept", "application/json")
                addHeader("Content-type", "application/json")

            }.build()

            val sitesResponse = client.newCall(sitesRequest).execute()
            Log.d(TAG, "SitesResponse: ${sitesResponse.message}")

            if (sitesResponse.code != 200) {
                Log.d(TAG,"Problem getting sites list")
                return@withContext "Unknown!!"
            }

            val decoder = Json {
                ignoreUnknownKeys = true
                explicitNulls = false
                isLenient = true
                coerceInputValues = true
            }

            val sitesBodyContent = sitesResponse.body?.string() ?: """{"meta":{ "rc": "fail"},"data": []}"""
            val sites = decoder.decodeFromString<Sites>(sitesBodyContent)

            sites.data.forEach { println("Site: ${it.name} \n ${it.desc}") }

            // going to assume first site has the Guest network
            val siteName = sites.data.first().name

            val wlanEndpoint = "$basepath/api/s/$siteName/rest/wlanconf/"

            val wlanRequest = with(Request.Builder()) {
                url(wlanEndpoint)
                addHeader("Accept", "application/json")
                addHeader("Content-type", "application/json")

            }.build()

            val wlanResponse = client.newCall(wlanRequest).execute()


            if (wlanResponse.code != 200) {
                Log.d(TAG,"Problem getting wlanResponse list ${wlanResponse.body?.string()}")
                return@withContext "Unknown!!"
            }


            val wlanBodyContent = wlanResponse.body?.string() ?: """{"meta":{ "rc": "fail"},"data": []}"""
            val wlans = decoder.decodeFromString<WlanConfs>(wlanBodyContent)



            println(" wlans: $wlans")
            println(" wlanBodyContent: $wlanBodyContent")

            val guestWlan = wlans.data.first { it.isGuest == true }

            networkPassword = guestWlan.xPassphrase
            return@withContext networkPassword


//            val siteObj = Json.decodeFromString(sites)
//            if csrf_token is None:
//            raise UnifiInstantiationError("CSRF token not found in login response")
//
//            self.session.headers.update({"Cookie": cookie, "x-csrf-token": csrf_token})
//
//            def change_wifi_password(self, network_id, new_password):
//            network_url = f"https://{self.controller}:443/proxy/network/api/s/default/rest/wlanconf/{network_id}"
//            network_payload = {"x_passphrase": new_password}
//
//            response = self.session.put(network_url, json=network_payload)
//
//            if response.status_code != 200:
//            raise UnifiActionError(f"Network '{network_id}' password update failed")
//        unifi_client = UnifiClient(administration_host, administration_username, administration_password)
//        unifi_client.change_wifi_password(wifi_id, wifi_password)
//        print(f"Network '{wifi_id}' password updated")

        }
    }

}