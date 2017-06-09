package com.sample.application.widget

import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ProgressBar
import com.sample.application.R
import org.jetbrains.anko._FrameLayout

/**
 * Created by tomykho on 5/19/17.
 */

class StateView(context: Context) : _FrameLayout(context) {

    val loadingView: ProgressBar = ProgressBar(context)
    var errorView: View? = null
    var loadedView: View? = null
    var emptyView: View? = null

    var state: Int = LOADING
        set(v) {
            val visibleView: View?
            when (v) {
                ERROR -> visibleView = errorView
                LOADED -> visibleView = loadedView
                EMPTY -> visibleView = emptyView
                else -> visibleView = loadingView
            }
            visibleView?.visibility = View.VISIBLE
            arrayOf(loadingView, errorView, loadedView, emptyView)
                    .filter { it != visibleView }
                    .forEach { it?.visibility = View.GONE }
        }

    companion object {
        const val ERROR = R.id.error
        const val LOADING = R.id.loading
        const val LOADED = R.id.loaded
        const val EMPTY = R.id.empty
    }

    init {
        val layoutParams = LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.gravity = Gravity.CENTER
        addView(loadingView, layoutParams)
    }

    override fun onViewAdded(child: View?) {
        super.onViewAdded(child)
        if (child != null) {
            if (child != loadingView) {
                child.visibility = GONE
                when (child.id) {
                    EMPTY -> emptyView = child
                    LOADED -> loadedView = child
                    ERROR -> errorView = child
                }
            }
        }
    }

}