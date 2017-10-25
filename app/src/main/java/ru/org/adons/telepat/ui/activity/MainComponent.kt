package ru.org.adons.telepat.ui.activity

import dagger.Component
import ru.org.adons.telepat.app.AppComponent
import ru.org.adons.telepat.ui.client.ClientFragment
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
@Component(dependencies = arrayOf(AppComponent::class))
interface MainComponent {

    fun inject(clientFragment: ClientFragment)

}