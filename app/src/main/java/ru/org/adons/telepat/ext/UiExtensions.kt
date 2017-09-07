package ru.org.adons.telepat.ext

import android.view.View

/**
 * Extensions for UI elements
 */

fun View.show() = let { visibility = View.VISIBLE }

fun View.hide() = let { visibility = View.INVISIBLE }

