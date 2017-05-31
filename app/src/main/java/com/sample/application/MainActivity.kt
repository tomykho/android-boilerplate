package com.sample.application

import android.os.Bundle
import android.util.Log
import com.sample.application.api.Api
import com.sample.application.base.BaseActivity
import com.sample.application.ui.MainLayout
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class MainActivity : BaseActivity() {

    override val layout = MainLayout()
    @Inject lateinit var api: Api
    var request: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout.albumsButton.setOnClickListener {
            request = api.findAlbums().subscribe(
                    { albums ->
                        Log.e("albums", albums.toString())
                    },
                    { e ->
                        onError(e)
                    }
            )
        }
    }

    override fun finish() {
        super.finish()
        request?.dispose()
    }

}