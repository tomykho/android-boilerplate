package com.boilerplate.ui

import android.app.Activity
import android.widget.Button
import com.boilerplate.base.BaseLayout
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
            padding = dimen(com.boilerplate.R.dimen.content_padding)
            postButton = button(com.boilerplate.R.string.post) {
            }
            albumsButton = button(com.boilerplate.R.string.albums) {
            }
        }
    }

}