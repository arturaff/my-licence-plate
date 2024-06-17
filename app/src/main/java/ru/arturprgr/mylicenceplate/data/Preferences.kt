package ru.arturprgr.mylicenceplate.data

import android.content.Context

class Preferences(context: Context) {
    private val sPrefs = context.getSharedPreferences("sPrefs", Context.MODE_PRIVATE)

    fun set(path: String, value: String) =
        sPrefs.edit().putString(path, value).apply()

    fun get(path: String): String = sPrefs.getString(path, "").toString()

    fun setAccount(value: String) = set("account", value)

    fun getAccount(): String = get("account")
}