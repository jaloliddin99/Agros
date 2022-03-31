package com.abdullaev.smartagro.common

import android.content.Context
import android.content.SharedPreferences
import com.abdullaev.smartagro.R

object SharedPreferences {

    fun setLoggedIn(context: Context, isLogIn: Boolean) {
        val sharedrefrence = context.getSharedPreferences("isLoggedIn", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedrefrence.edit()
        editor.putBoolean(context.getString(R.string.isLoggedIn), isLogIn).apply()
    }

    fun getLoggedIn(context: Context): Boolean {
        val sharedrefrence = context.getSharedPreferences("isLoggedIn", Context.MODE_PRIVATE)
        return sharedrefrence.getBoolean(context.getString(R.string.isLoggedIn), false)
    }
}