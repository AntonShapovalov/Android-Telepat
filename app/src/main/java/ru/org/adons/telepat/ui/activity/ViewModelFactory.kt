package ru.org.adons.telepat.ui.activity

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import ru.org.adons.telepat.ui.client.ClientViewModel
import java.lang.RuntimeException
import javax.inject.Inject

/**
 * Provide instance of [ClientViewModel]
 */
class ViewModelFactory @Inject constructor(
        private val clientViewModel: ClientViewModel
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>?): T = when {
        modelClass == null -> throw RuntimeException("Provide Class<T> for Factory")
        modelClass.isInstance(clientViewModel) -> clientViewModel as T
        else -> throw RuntimeException("Unknown ViewModel, inject it in constructor")
    }
}