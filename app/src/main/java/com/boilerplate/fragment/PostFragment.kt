package com.boilerplate.fragment

import android.os.Bundle
import com.boilerplate.base.BaseFragment
import com.boilerplate.ui.CreatePostLayout

/**
 * Created by tomykho on 6/13/17.
 */

class PostFragment : BaseFragment() {

    override val layout = CreatePostLayout()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}