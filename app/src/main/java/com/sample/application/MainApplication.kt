package com.sample.application

import android.app.Activity
import android.app.Application
import com.letv.sarrsdesktop.blockcanaryex.jrt.BlockCanaryEx
import com.letv.sarrsdesktop.blockcanaryex.jrt.Config
import com.squareup.leakcanary.LeakCanary
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.paperdb.Paper
import javax.inject.Inject

/**
 * Created by tomykho on 5/16/17.
 */

class MainApplication : Application(), HasActivityInjector {

    @Inject lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        if (BlockCanaryEx.isInSamplerProcess(this)) {
            return
        }
        super.onCreate()
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        DaggerAppComponent.create().inject(this)
        Paper.init(this)

        // BlockCanaryEx and LeakCanary must be last
        BlockCanaryEx.install(Config(this))
        LeakCanary.install(this)
    }

    override fun activityInjector() = activityInjector

}