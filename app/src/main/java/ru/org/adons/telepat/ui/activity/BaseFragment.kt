package ru.org.adons.telepat.ui.activity

import android.content.Context
import com.trello.rxlifecycle.components.RxFragment

/**
 * Base class for all Fragments
 * @param <T> - activity, must implement [IMainListener]
 */
abstract class BaseFragment<T : IMainListener> : RxFragment() {

    protected var listener: T? = null

    override fun onDetach() {
        listener = null
        super.onDetach()
    }

    /**
     * Set Activity as listener on fragment's events
     *
     * @param context Host Activity
     * @param tClass  listener class, which host activity must implement
     */
    protected fun <V : Context> setListener(context: V, tClass: Class<T>) {
        listener = tClass.cast(context)
    }

}