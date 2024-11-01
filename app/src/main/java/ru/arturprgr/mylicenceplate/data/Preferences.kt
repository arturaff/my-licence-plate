package ru.arturprgr.mylicenceplate.data

import android.content.Context
import ru.arturprgr.mylicenceplate.model.Achievement

class Preferences(context: Context) {
    private val sPrefs = context.getSharedPreferences("sPrefs", Context.MODE_PRIVATE)

    fun setAchievement(achievement: String, quantity: Int) = sPrefs.edit().putInt(achievement, quantity).apply()

    fun getAchievement(achievement: String) = sPrefs.getInt(achievement, 0)

    fun setAccount(value: String) = sPrefs.edit().putString("account", value).apply()

    fun getAccount(): String = "${sPrefs.getString("account", "")}"
}