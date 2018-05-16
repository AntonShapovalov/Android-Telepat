package mobile.addons.telepat.ui.activity

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import mobile.addons.telepat.ui.client.ClientViewModel
import java.lang.RuntimeException
import javax.inject.Inject

/**
 * Provide instance of [ClientViewModel]
 */
class ViewModelFactory @Inject constructor(
        private val clientViewModel: ClientViewModel
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isInstance(clientViewModel) -> clientViewModel as T
            else -> throw RuntimeException("Unknown ViewModel, inject it in constructor")
        }
    }
}