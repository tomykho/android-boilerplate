package com.sample.application.ui

import android.app.Activity
import com.sample.application.base.BaseLayout
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.verticalLayout

/**
 * Created by tomykho on 5/19/17.
 */

class CreatePostLayout : BaseLayout() {

    override fun createView(ui: AnkoContext<Activity>) = with(ui) {
        verticalLayout {
            editText()
            button(com.sample.application.R.string.post) {
            }
        }
    }

}