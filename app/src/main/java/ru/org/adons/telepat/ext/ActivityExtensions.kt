package ru.org.adons.telepat.ext

import android.app.Activity
import android.app.Fragment

/**
 * Extensions for [Activity]
 */

fun Activity.getFragment(tag: String): Fragment? = fragmentManager.findFragmentByTag(tag)

fun Activity.addFragment(containerId: Int, fragment: Fragment, tag: String) = fragmentManager
        .beginTransaction().add(containerId, fragment, tag).commit()