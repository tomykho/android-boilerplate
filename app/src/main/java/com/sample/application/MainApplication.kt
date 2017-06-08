package com.sample.application

import android.app.Application
import com.letv.sarrsdesktop.blockcanaryex.jrt.BlockCanaryEx
import com.letv.sarrsdesktop.blockcanaryex.jrt.Config
import com.squareup.leakcanary.LeakCanary
import io.paperdb.Paper

/**
 * Created by tomykho on 5/16/17.
 */

class MainApplication : Application() {

    override fun onCreate() {
        if (BlockCanaryEx.isInSamplerProcess(this)) {
            return
        }
        super.onCreate()
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        // Initialization
        Paper.init(this)

        // BlockCanaryEx and LeakCanary must be last
        BlockCanaryEx.install(Config(this))
        LeakCanary.install(this)
    }

}