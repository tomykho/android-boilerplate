package com.sample.application

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by tomykho on 5/31/17.
 */

@Module()
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivityInjector(): MainActivity

}