package ru.org.adons.telepat.ext

import android.app.Activity
import android.app.Fragment
import android.app.FragmentTransaction
import ru.org.adons.telepat.R
import ru.org.adons.telepat.ui.activity.MainActivity

/**
 * Extensions for [Activity]
 */

fun Activity.getFragment(tag: String): Fragment? = fragmentManager.findFragmentByTag(tag)

fun Activity.addFragment(containerId: Int, fragment: Fragment, tag: String) = fragmentManager
        .beginTransaction().add(containerId, fragment, tag).commit()

fun Activity.replaceFragment(
        containerId: Int = R.id.fragment_container,
        newFragment: Fragment,
        tag: String,
        backStackTag: String = MainActivity.MAIN_FRAGMENT_TAG
) {
    fragmentManager.beginTransaction().also {
        it.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        it.addToBackStack(backStackTag)
        it.replace(containerId, newFragment, tag)
    }.commit()
}
