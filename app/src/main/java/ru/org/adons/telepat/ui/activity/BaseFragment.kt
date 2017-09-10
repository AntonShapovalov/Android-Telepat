package ru.org.adons.telepat.ui.activity

import android.content.Context
import com.trello.rxlifecycle.components.RxFragment

/**
 * Base class for all Fragments of [MainActivity]
 */
abstract class BaseFragment : RxFragment() {

    protected var listener: IMainListener? = null

    override fun onDetach() {
        listener = null
        super.onDetach()
    }

    /**
     * Set Activity as listener on fragment's events
     *
     * @param context Host Activity
     */
    protected fun setListener(context: Context) {
        listener = IMainListener::class.java.cast(context)
    }

}