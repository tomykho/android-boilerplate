package com.sample.application.base

import android.view.View
import com.sample.application.ui.toolbar
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko._LinearLayout
import org.jetbrains.anko.verticalLayout

/**
 * Created by tomykho on 5/18/17.
 */

abstract class BaseLayout : AnkoComponent<BaseActivity> {

    override fun createView(ui: AnkoContext<BaseActivity>) = with(ui) {
        verticalLayout {
            owner.toolbar = toolbar()
            contentView(this)
        }
    }

    abstract fun contentView(layout: _LinearLayout): View

}