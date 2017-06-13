package com.sample.application.ui

import android.app.Activity
import com.sample.application.R
import com.sample.application.base.BaseLayout
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.frameLayout

/**
 * Created by tomykho on 5/19/17.
 */

class ContainerLayout : BaseLayout() {

    override fun createView(ui: AnkoContext<Activity>) = with(ui) {
        frameLayout {
            id = R.id.container
        }
    }

}