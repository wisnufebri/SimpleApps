package co.android.wframadhan.techtest.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

class PreferenceProvider(private val appContext: Context) {

    val preference: SharedPreferences
        get() = PreferenceManager.getDefaultSharedPreferences(appContext)


    fun getBoolean(key: String): Boolean {
        return preference.getBoolean(EncUtils.md5(key), false)
    }
}