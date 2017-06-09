package com.sample.application.activity

import android.os.Bundle
import com.sample.application.base.BaseActivity
import com.sample.application.ui.MainLayout
import org.jetbrains.anko.startActivity

class MainActivity : BaseActivity() {

    override val layout = MainLayout()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout.albumsButton.setOnClickListener {
            startActivity<AlbumActivity>()
        }
    }

}