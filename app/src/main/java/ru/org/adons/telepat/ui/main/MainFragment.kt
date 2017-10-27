package ru.org.adons.telepat.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*
import ru.org.adons.telepat.R
import ru.org.adons.telepat.ext.log
import ru.org.adons.telepat.ui.activity.mainComponent
import ru.org.adons.telepat.ui.activity.showClientFragment
import ru.org.adons.telepat.ui.activity.showServerFragment
import rx.Completable
import rx.Subscription
import rx.schedulers.Schedulers

/**
 * Main screen, allow to select Server or Client role
 */
class MainFragment : Fragment() {

    var subscription: Subscription? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater
            .inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // build application component in background
        subscription = Completable.fromAction { activity?.mainComponent() }
                .subscribeOn(Schedulers.io())
                .doOnCompleted { log("MainComponent build finished") }
                .subscribe({ buttonOk.setOnClickListener { selectRole() } }, { it.printStackTrace() })
    }

    override fun onDestroyView() {
        subscription?.unsubscribe()
        subscription = null
        super.onDestroyView()
    }

    private fun selectRole() = when (radioGroup.checkedRadioButtonId) {
        R.id.radioButtonClient -> activity?.showClientFragment()
        else -> activity?.showServerFragment()
    }

}