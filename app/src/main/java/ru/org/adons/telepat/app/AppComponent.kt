package ru.org.adons.telepat.app

import android.content.Context
import dagger.Component
import javax.inject.Singleton

/**
 * Provide Application scope dependencies
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun context(): Context

}