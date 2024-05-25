package com.tmpsolutions.ui

import android.app.Activity
import android.os.Build
import android.view.View
import android.view.WindowInsets
import android.view.WindowMetrics
import androidx.annotation.RequiresApi
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsCompat.Type

@RequiresApi(Build.VERSION_CODES.M)
fun getNavigationBarHeight(activity: Activity): Int {
    val decorView = activity.window.decorView
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        val windowMetrics: WindowMetrics = activity.windowManager.currentWindowMetrics
        val insets: WindowInsets = windowMetrics.windowInsets
        val navBarInsets = insets.getInsets(WindowInsets.Type.navigationBars())
        navBarInsets.bottom
    } else {
        val insetsCompat = WindowInsetsCompat.toWindowInsetsCompat(decorView.rootWindowInsets)
        insetsCompat.getInsets(Type.systemBars()).bottom
    }
}