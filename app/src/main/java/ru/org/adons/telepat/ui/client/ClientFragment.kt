package ru.org.adons.telepat.ui.client

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_client.*
import ru.org.adons.telepat.R
import ru.org.adons.telepat.ext.initGrid
import ru.org.adons.telepat.ui.activity.BaseFragment
import ru.org.adons.telepat.ui.client.KeyboardListAdapter.Companion.REMOVE_CODE

/**
 * Client screen, display score of guessed numbers
 */
class ClientFragment : BaseFragment() {

    @Suppress("OverridingDeprecatedMember", "DEPRECATION")
    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        activity?.let { setListener(activity) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater
            .inflate(R.layout.fragment_client, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gridKeyboard.initGrid(adapter = KeyboardListAdapter { onKeyClick(it) }, columnCount = 3)
    }

    private fun onKeyClick(value: Int) {
        val s = value.toString()
        with(textNumber) {
            text = when (value) {
                REMOVE_CODE -> "?"
                else -> if (text == "?") s else text.toString().plus(s)
            }
        }
    }

}