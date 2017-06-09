package com.sample.application.ui

import android.view.Gravity
import android.widget.Button
import com.sample.application.R
import com.sample.application.base.BaseLayout
import org.jetbrains.anko.*

/**
 * Created by tomykho on 5/19/17.
 */

class MainLayout : BaseLayout() {
    lateinit var albumsButton: Button

    override fun contentView(layout: _LinearLayout) = with(layout) {
        verticalLayout {
            lparams(width = matchParent, height = matchParent)
            gravity = Gravity.CENTER
            padding = dimen(R.dimen.content_padding)
            button(R.string.post) {
            }
            albumsButton = button(R.string.albums) {
            }
        }
    }

    override fun toolbar(layout: _LinearLayout) = null

}