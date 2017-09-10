package ru.org.adons.telepat.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.org.adons.telepat.R
import ru.org.adons.telepat.ext.*
import ru.org.adons.telepat.ui.client.ClientFragment
import ru.org.adons.telepat.ui.main.MainFragment
import ru.org.adons.telepat.ui.server.ServerFragment

/**
 * Entry point for Application
 */
class MainActivity : AppCompatActivity(), IMainListener {

    companion object {
        const val MAIN_FRAGMENT_TAG = "MAIN_FRAGMENT_TAG"
    }

    private val SERVER_FRAGMENT_TAG = "SERVER_FRAGMENT_TAG"
    private val CLIENT_FRAGMENT_TAG = "CLIENT_FRAGMENT_TAG"

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

    override fun showServerFragment() = replaceFragment(
            newFragment = getFragment(SERVER_FRAGMENT_TAG) ?: ServerFragment(),
            tag = SERVER_FRAGMENT_TAG
    )

    override fun showClientFragment() = replaceFragment(
            newFragment = getFragment(CLIENT_FRAGMENT_TAG) ?: ClientFragment(),
            tag = CLIENT_FRAGMENT_TAG
    )

}
