package com.sample.application.ui

import android.app.Activity
import android.widget.Button
import com.sample.application.base.BaseLayout
import org.jetbrains.anko.*

/**
 * Created by tomykho on 5/19/17.
 */

class MainLayout : BaseLayout() {

    lateinit var postButton: Button
    lateinit var albumsButton: Button

    override fun createView(ui: AnkoContext<Activity>) = with(ui) {
        verticalLayout {
            lparams(width = matchParent, height = matchParent)
            gravity = android.view.Gravity.CENTER
            padding = dimen(com.sample.application.R.dimen.content_padding)
            postButton = button(com.sample.application.R.string.post) {
            }
            albumsButton = button(com.sample.application.R.string.albums) {
            }
        }
    }

}