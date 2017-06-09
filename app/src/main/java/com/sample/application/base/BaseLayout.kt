package com.sample.application.base

import android.support.v7.widget.Toolbar
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
            val toolbar = toolbar(this)
            if (toolbar != null) {
                owner.toolbar = toolbar
            }
            contentView(this)
        }
    }

    open fun toolbar(layout: _LinearLayout): Toolbar? = with(layout) {
        toolbar()
    }

    abstract fun contentView(layout: _LinearLayout): View

}