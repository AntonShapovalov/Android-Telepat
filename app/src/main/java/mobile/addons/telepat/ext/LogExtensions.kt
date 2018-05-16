package mobile.addons.telepat.ext

import android.util.Log

/**
 * Extensions for [Log]
 */

fun log(message: String, tag: String = "***LOG") {
    Log.d(tag, message)
}