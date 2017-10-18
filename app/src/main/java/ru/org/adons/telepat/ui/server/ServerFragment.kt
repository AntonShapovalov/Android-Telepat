package ru.org.adons.telepat.ui.server

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.org.adons.telepat.R

/**
 * Server screen, display random number, which client must guess
 */
class ServerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater
            .inflate(R.layout.fragment_server, container, false)

}