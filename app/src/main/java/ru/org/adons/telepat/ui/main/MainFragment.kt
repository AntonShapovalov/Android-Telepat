package ru.org.adons.telepat.ui.main

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*
import ru.org.adons.telepat.R
import ru.org.adons.telepat.ui.activity.BaseFragment

/**
 * Main screen, allow to select Server or Client role
 */
class MainFragment : BaseFragment() {

    @Suppress("OverridingDeprecatedMember", "DEPRECATION")
    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        activity?.let { setListener(activity) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater
            .inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonOk.setOnClickListener { selectRole() }
    }

    private fun selectRole() {
        when (radioGroup.checkedRadioButtonId) {
            R.id.radioButtonClient -> listener?.showClientFragment()
            else -> listener?.showServerFragment()
        }
    }

}