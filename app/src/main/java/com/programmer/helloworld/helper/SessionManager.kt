package com.programmer.helloworld

// SessionManager.kt

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {
    private val prefName = "MyPref"
    private val keyUsername = "username"
    private val keyMobileNumber = "mobile_number"

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = sharedPreferences.edit()

    var username: String?
        get() = sharedPreferences.getString(keyUsername, "")
        set(value) = editor.putString(keyUsername, value).apply()

    var mobileNumber: String?
        get() = sharedPreferences.getString(keyMobileNumber, "")
        set(value) = editor.putString(keyMobileNumber, value).apply()

    fun clearSession() {
        editor.clear().apply()
    }
}
