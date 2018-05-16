package mobile.addons.telepat.ui.activity

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import mobile.addons.telepat.R
import mobile.addons.telepat.app.TelepatApplication
import mobile.addons.telepat.ext.addFragment
import mobile.addons.telepat.ext.getFragment
import mobile.addons.telepat.ext.replaceFragment
import mobile.addons.telepat.ui.client.ClientFragment
import mobile.addons.telepat.ui.main.MainFragment
import mobile.addons.telepat.ui.server.ServerFragment

const val MAIN_FRAGMENT_TAG = "MAIN_FRAGMENT_TAG"
const val SERVER_FRAGMENT_TAG = "SERVER_FRAGMENT_TAG"
const val CLIENT_FRAGMENT_TAG = "CLIENT_FRAGMENT_TAG"

/**
 * Entry point for Application
 */
class MainActivity : AppCompatActivity() {

    val mainComponent: MainComponent by lazy { buildMainComponent() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var fragment = getFragment(MAIN_FRAGMENT_TAG)
        if (fragment == null) {
            fragment = MainFragment()
            addFragment(R.id.fragment_container, fragment, MAIN_FRAGMENT_TAG)
        }
    }

    private fun buildMainComponent(): MainComponent = DaggerMainComponent.builder()
            .appComponent((application as TelepatApplication).appComponent)
            .build()

}

fun FragmentActivity.mainComponent() = (this as MainActivity).mainComponent

fun FragmentActivity.showClientFragment() = replaceFragment(
        newFragment = getFragment(CLIENT_FRAGMENT_TAG) ?: ClientFragment(),
        tag = CLIENT_FRAGMENT_TAG
)

fun FragmentActivity.showServerFragment() = replaceFragment(
        newFragment = getFragment(SERVER_FRAGMENT_TAG) ?: ServerFragment(),
        tag = SERVER_FRAGMENT_TAG
)
