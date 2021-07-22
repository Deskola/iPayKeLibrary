package com.example.ipayweblib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webView = findViewById(R.id.webview)
//        payment = Payment()
        loadWebView()
    }

    fun loadWebView() {
        val live = live
        val oid = oid
        val inv = inv
        val ttl = ttl
        val tel = tel
        val eml = eml
        val vid = vid
        val curr = curr
        val p1 = p1
        val p2 = p2
        val p3 = p3
        val p4 = p4
        val cbk = cbk
        val cst = cst
        val crl = crl

//        val viewModelJob = Job()
//        val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

        val data = "$live$oid$inv$ttl$tel$eml$vid$curr$p1$p2$p3$p4$cbk$cst$crl"
        val hashString = HmacSha1Sig.calculateRFC210HMAC(data, hashKey)
        Log.i("Hash", hashString)

        //crafting the url
        val ipayUri =
            "https://payments.ipayafrica.com/v3/ke?live=$live&oid=$oid&inv=$inv&ttl=$ttl&tel=$tel&eml=$eml&vid=$vid&curr=$curr&p1=$p1&p2=$p2&p3=$p3&p4=$p4&cbk=$cbk&cst=$cst&crl=$crl&hsh=$hashString&autopay=0"

        webView.loadUrl(ipayUri);
    }
}