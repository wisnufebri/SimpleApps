package co.android.wframadhan.techtest.utils

import android.util.Base64
import java.io.UnsupportedEncodingException
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

object EncUtils {

    private const val TAG = "EncUtils"

    private fun padRight(s: String?, n: Int, param: Char): String? {
        return String.format("%-" + n + "s", s).replace(' ', param)
    }

    private fun toByte(hex: String): ByteArray {
//        if (hex.isNullOrEmpty())
//            return null
        val ba = ByteArray(hex.length / 2)
        for (i in ba.indices) {
            ba[i] = hex.substring(2 * i, 2 * i + 2).toInt(16).toByte()
        }
        return ba
    }

    private fun toHex(ba: ByteArray): String {
        val sb = StringBuffer(ba.size * 2)
        var hexNumber: String
        for (x in ba.indices) {
            hexNumber = "0" + Integer.toHexString(0xff and ba[x].toInt())
            sb.append(hexNumber.substring(hexNumber.length - 2))
        }
        return sb.toString()
    }

    fun md5(s: String): String {
        return try {
            val md = MessageDigest.getInstance("MD5")
            val messageDigest = md.digest(s.toByteArray())
            val number = BigInteger(1, messageDigest)
            val hashText = StringBuilder(number.toString(16))
            while (hashText.length < 32) {
                hashText.insert(0, "0")
            }
            hashText.toString()
        } catch (e: NoSuchAlgorithmException) {
            throw RuntimeException(e)
        }
    }

    fun encrypt(input: String): String {
        var encodedValue = ""
        try {
            if (input.isEmpty())
                return input
            encodedValue =
                encodeBase64(input.toByteArray())
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
        return encodedValue
    }

    fun decrypt(input: String): String {
        var clearValue = ""
        try {
            if (input.isEmpty())
                return input
            clearValue =
                decodeBase64(input.toByteArray())
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
        return clearValue
    }

    @Throws(UnsupportedEncodingException::class)
    fun encodeBase64(byte: ByteArray): String {
        val tempParam = Base64.encode(byte, Base64.DEFAULT)
        return String(tempParam, Charsets.UTF_8)
    }

    private fun decodeBase64(byte: ByteArray): String {
        val tempParam = Base64.decode(byte, Base64.DEFAULT)
        return try {
            String(tempParam, Charsets.UTF_8)
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
            ""
        }
    }
}