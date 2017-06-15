package com.boilerplate.ui

import android.app.Activity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.boilerplate.base.BaseLayout
import com.boilerplate.widget.StateView
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView

/**
 * Created by tomykho on 5/19/17.
 */

class RecyclerLayout : BaseLayout() {

    lateinit var stateView: StateView
    lateinit var recyclerView: RecyclerView

    override fun createView(ui: AnkoContext<Activity>) = with(ui) {
        stateView {
            stateView = this
            lparams(width = matchParent, height = matchParent)
            recyclerView {
                id = StateView.LOADED
                lparams(width = matchParent, height = matchParent)
                recyclerView = this
                layoutManager = LinearLayoutManager(context)
            }
        }
    }

}