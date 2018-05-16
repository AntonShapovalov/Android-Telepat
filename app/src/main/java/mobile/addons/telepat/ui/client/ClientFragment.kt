package mobile.addons.telepat.ui.client

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_client.*
import mobile.addons.telepat.R
import mobile.addons.telepat.ext.initGrid
import mobile.addons.telepat.ui.activity.ViewModelFactory
import mobile.addons.telepat.ui.activity.mainComponent
import mobile.addons.telepat.ui.client.KeyboardListAdapter.Companion.GUESS_CODE
import mobile.addons.telepat.ui.client.KeyboardListAdapter.Companion.REMOVE_CODE
import javax.inject.Inject

/**
 * Client screen, display score of guessed numbers
 */
class ClientFragment : Fragment() {

    @Inject lateinit var factory: ViewModelFactory

    private lateinit var viewModel: ClientViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater
            .inflate(R.layout.fragment_client, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gridKeyboard.initGrid(adapter = KeyboardListAdapter { onKeyClick(it) }, columnCount = 3)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.mainComponent()?.inject(this)
        viewModel = ViewModelProviders.of(this, factory).get(ClientViewModel::class.java)
        viewModel.score.observe(this, Observer { textScore.text = it })
        viewModel.getCurrentScore()
    }

    private fun onKeyClick(value: Int) {
        val s = value.toString()
        with(textNumber) {
            text = when (value) {
                REMOVE_CODE -> "?"
                GUESS_CODE -> text.toString()
                else -> if (text == "?") s else text.toString().plus(s)
            }
        }
    }

}