package com.cristhian.apprecordar.data.utils

import android.content.Context
import android.content.SharedPreferences

class Prefs(context:Context) {
    val PREFS_NAME = "Prefs name"
    val SHARED_NAME = "Shared name"

    val PREFS_JWT = "Prefs jwt"
    val SHARED_JWT = "Shared jwt"

    val prefsName: SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)
    val prefsJWT: SharedPreferences = context.getSharedPreferences(PREFS_JWT, 0)

    var name: String
        get() = prefsName.getString(SHARED_NAME, "").toString()
        set(value) =prefsName.edit().putString(SHARED_NAME, value).apply()

    var jwt: String
        get() = prefsJWT.getString(SHARED_JWT, "").toString()
        set(value) = prefsJWT.edit().putString(SHARED_JWT, value).apply()

}