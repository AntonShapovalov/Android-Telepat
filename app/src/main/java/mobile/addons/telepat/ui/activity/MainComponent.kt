package mobile.addons.telepat.ui.activity

import dagger.Component
import mobile.addons.telepat.app.AppComponent
import mobile.addons.telepat.ui.client.ClientFragment
import javax.inject.Scope

/**
 * Scope for all sub-components of [AppComponent]
 */
@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class ViewScope

/**
 * Provide [ViewScope] dependencies based on [AppComponent]
 */
@ViewScope
@Component(dependencies = [(AppComponent::class)])
interface MainComponent {

    fun inject(clientFragment: ClientFragment)

}