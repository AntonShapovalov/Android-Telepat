package ru.org.adons.telepat.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.org.adons.telepat.R
import ru.org.adons.telepat.ext.addFragment
import ru.org.adons.telepat.ext.getFragment
import ru.org.adons.telepat.ext.hide
import ru.org.adons.telepat.ext.show
import ru.org.adons.telepat.ui.main.MainFragment

/**
 * Entry point for Application
 */
class MainActivity : AppCompatActivity(), IMainListener {

    private val MAIN_FRAGMENT_TAG = "MAIN_FRAGMENT_TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var fragment = getFragment(MAIN_FRAGMENT_TAG)
        if (fragment == null) {
            fragment = MainFragment()
            addFragment(R.id.fragment_container, fragment, MAIN_FRAGMENT_TAG)
        }
    }

    override fun showProgress() = runOnUiThread { progress.show() }

    override fun hideProgress() = runOnUiThread { progress.hide() }

}
