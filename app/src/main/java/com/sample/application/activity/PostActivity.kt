package com.sample.application.activity

import android.os.Bundle
import com.sample.application.R
import com.sample.application.base.BaseActivity
import com.sample.application.fragment.PostFragment
import com.sample.application.ui.ContainerLayout

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
