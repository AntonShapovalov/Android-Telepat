package ru.org.adons.telepat.app

import android.app.Application

/**
 * Instance of Application, provide Singleton dependencies via [AppComponent]
 */
class TelepatApplication : Application() {

    val appComponent: AppComponent by lazy { buildAppComponent() }

    private fun buildAppComponent(): AppComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .build()

}