package com.sample.application.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.AnkoContext

/**
 * Created by tomykho on 5/18/17.
 */

abstract class BaseFragment : Fragment() {

    abstract val layout: BaseLayout

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return with(AnkoContext.create(activity, activity)) {
            layout.createView(this)
        }
    }

}
