package com.sample.application.fragment

import android.os.Bundle
import com.sample.application.base.BaseFragment
import com.sample.application.ui.CreatePostLayout

/**
 * Created by tomykho on 6/13/17.
 */

class PostFragment : BaseFragment() {

    override val layout = CreatePostLayout()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}