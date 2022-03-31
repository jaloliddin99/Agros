package com.abdullaev.smartagro.utils

import android.content.Context
import android.os.Build
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.annotation.ColorInt
import androidx.annotation.RequiresApi
import androidx.fragment.app.FragmentActivity

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun FragmentActivity.statusBarColor(
    @ColorInt statusBarColor: Int,
    @ColorInt navigationBarColor: Int,
    darkStatusBarTint: Boolean
) {
    val win: Window = (window).also {
        it.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        it.statusBarColor = statusBarColor
        it.navigationBarColor = navigationBarColor
    }

    val dec = win.decorView
    if (darkStatusBarTint) {
        dec.systemUiVisibility = dec.systemUiVisibility or
                View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    } else {
        dec.systemUiVisibility = 0
    }
}

fun dipToPixels(context: Context, dipValue: Float): Float {
    val metrics: DisplayMetrics = context.resources.displayMetrics
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics)
}




