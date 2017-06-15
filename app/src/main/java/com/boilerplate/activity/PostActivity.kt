package com.boilerplate.activity

import android.os.Bundle
import com.boilerplate.R
import com.boilerplate.base.BaseActivity
import com.boilerplate.fragment.PostFragment
import com.boilerplate.ui.ContainerLayout

/**
 * Created by tomykho on 6/13/17.
 */

class PostActivity : BaseActivity() {

    override val layout = ContainerLayout()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, PostFragment())
                .commit()
    }

}
