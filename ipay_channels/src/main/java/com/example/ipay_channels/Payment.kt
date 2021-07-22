package com.example.ipay_channels

class Payment(
    private val live: String,
    private val oid: String,
    private val inv: String,
    private val ttl: String,
    private val tel: String,
    private val eml: String,
    private val vid: String,
    private val curr: String,
    private val p1: String? = null,
    private val p2: String? = null,
    private val p3: String? = null,
    private val p4: String? = null,
    private val cbk: String,
    private val cst: String,
    private val crl: String,
    private val hsh: String
) {

    fun getIpayUri(): String {

        val data = "$live$oid$inv$ttl$tel$eml$vid$curr$p1$p2$p3$p4$cbk$cst$crl"

        val hashString = HmacSha1Sig.calculateRFC210HMAC(data, hsh)

        //crafting the url
        return "https://payments.ipayafrica.com/v3/ke?live=$live&oid=$oid&inv=$inv&ttl=$ttl&tel=$tel&eml=$eml&vid=$vid&curr=$curr&p1=$p1&p2=$p2&p3=$p3&p4=$p4&cbk=$cbk&cst=$cst&crl=$crl&hsh=$hashString&autopay=0"
    }

}