package ru.org.adons.telepat.ui.server

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.org.adons.telepat.R
import ru.org.adons.telepat.ui.activity.BaseFragment

/**
 * Server screen, display random number, which client must guess
 */
class ServerFragment : BaseFragment() {

    @Suppress("OverridingDeprecatedMember", "DEPRECATION")
    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        activity?.let { setListener(activity) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater
            .inflate(R.layout.fragment_server, container, false)

}