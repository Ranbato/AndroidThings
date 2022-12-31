package com.example.myapplication.services

import android.graphics.Bitmap
import net.glxn.qrgen.android.QRCode
import net.glxn.qrgen.core.scheme.Wifi

class QRService {

    private var bitmapCache :Bitmap? = null


    private suspend fun generateQRCode(
        wifiSSID: String,
        wifiPassword: String,
        encryption: String = "",
        hidden: Boolean = false
    ): Bitmap {

        val wifi = Wifi().withSsid(wifiSSID).withHidden(hidden).withAuthentication(Wifi.Authentication.valueOf(encryption)).withPsk(wifiPassword)
        val bitmap = QRCode.from(wifi).bitmap()
        bitmapCache = bitmap

        return bitmap

    }


    public suspend fun getQRCode(        wifiSSID: String,
                          wifiPassword: String,
                          encryption: String = "",
                          hidden: Boolean = false,
                                         regenerate: Boolean = false
    ): Bitmap {
        var bitmap = bitmapCache
        if(bitmap == null || regenerate){
            bitmap = generateQRCode(wifiSSID,wifiPassword,encryption, hidden)

        }
        return bitmap
    }
}