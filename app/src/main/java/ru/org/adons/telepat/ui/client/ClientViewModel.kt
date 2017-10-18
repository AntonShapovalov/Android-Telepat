package ru.org.adons.telepat.ui.client

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import ru.org.adons.telepat.R
import javax.inject.Inject

/**
 * Keep state of [ClientFragment]
 */
class ClientViewModel @Inject constructor() : ViewModel() {

    @Inject lateinit var context: Context

    private var success = 0
    private var failure = 0
    var score: MutableLiveData<String> = MutableLiveData()

    fun getCurrentScore() {
        score.value = context.getString(R.string.score, success, failure)
    }

}