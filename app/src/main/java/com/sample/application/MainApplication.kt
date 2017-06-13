package com.sample.application

import android.app.Application
import com.squareup.leakcanary.LeakCanary
import io.paperdb.Paper

/**
 * Created by tomykho on 5/16/17.
 */

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        // Initialization
        LeakCanary.install(this)
        Paper.init(this)
    }

}