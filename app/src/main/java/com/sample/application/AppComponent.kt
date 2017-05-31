package com.sample.application

import com.sample.application.api.ApiModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = arrayOf(
                AndroidInjectionModule::class,
                ApiModule::class,
                ActivityModule::class
        )
)
interface AppComponent {
    fun inject(app: MainApplication)
}