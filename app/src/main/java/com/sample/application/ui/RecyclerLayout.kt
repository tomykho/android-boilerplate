package com.sample.application.ui

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.sample.application.base.BaseLayout
import com.sample.application.widget.StateView
import org.jetbrains.anko._LinearLayout
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView

/**
 * Created by tomykho on 5/19/17.
 */

class RecyclerLayout : BaseLayout() {

    lateinit var stateView: StateView
    lateinit var recyclerView: RecyclerView

    override fun contentView(layout: _LinearLayout) = with(layout) {
        stateView {
            stateView = this
            lparams(width = matchParent, height = 0, weight = 1f)
            recyclerView {
                id = StateView.LOADED
                lparams(width = matchParent, height = matchParent)
                recyclerView = this
                layoutManager = LinearLayoutManager(context)
            }
        }
    }

}