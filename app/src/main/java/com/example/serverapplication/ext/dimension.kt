package com.example.serverapplication.ext

import android.content.Context

fun Float.pxToSp(context: Context): Float {
    val density = context.resources.displayMetrics.scaledDensity
    return this / density
}
