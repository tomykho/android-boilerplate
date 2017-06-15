package com.boilerplate.activity

import android.os.Bundle
import com.boilerplate.base.BaseActivity
import com.boilerplate.ui.MainLayout
import org.jetbrains.anko.startActivity

class MainActivity : BaseActivity() {

    override val layout = MainLayout()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        layout.postButton.setOnClickListener {
            startActivity<PostActivity>()
        }
        layout.albumsButton.setOnClickListener {
            startActivity<AlbumActivity>()
        }
    }

}