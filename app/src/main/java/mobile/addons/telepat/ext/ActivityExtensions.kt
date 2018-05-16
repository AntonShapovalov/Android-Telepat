package mobile.addons.telepat.ext

import android.app.Activity
import android.app.FragmentTransaction
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import mobile.addons.telepat.R
import mobile.addons.telepat.ui.activity.MAIN_FRAGMENT_TAG

/**
 * Extensions for [Activity]
 */

fun FragmentActivity.getFragment(tag: String): Fragment? = supportFragmentManager.findFragmentByTag(tag)

fun FragmentActivity.addFragment(containerId: Int, fragment: Fragment, tag: String) = supportFragmentManager
        .beginTransaction().add(containerId, fragment, tag).commit()

fun FragmentActivity.replaceFragment(
        containerId: Int = R.id.fragment_container,
        newFragment: Fragment,
        tag: String,
        backStackTag: String = MAIN_FRAGMENT_TAG
) {
    supportFragmentManager.beginTransaction().also {
        it.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        it.addToBackStack(backStackTag)
        it.replace(containerId, newFragment, tag)
    }.commit()
}
