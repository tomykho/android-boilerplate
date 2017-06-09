package com.sample.application.activity

import android.content.Intent
import android.support.v7.widget.GridLayoutManager
import com.sample.application.adapter.PhotoAdapter
import com.sample.application.api.Api
import com.sample.application.base.BaseActivity
import com.sample.application.model.Album
import com.sample.application.ui.RecyclerLayout
import com.sample.application.widget.StateView
import io.reactivex.disposables.Disposable
import org.parceler.Parcels

class PhotoActivity : BaseActivity() {

    companion object {
        const val EXTRA_ALBUM = "album"
    }

    override val layout = RecyclerLayout()
    var request: Disposable? = null
    val adapter = PhotoAdapter()

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        layout.recyclerView.layoutManager = GridLayoutManager(this, 4)
        layout.recyclerView.adapter = adapter
        val album = intent.getAlbum()
        request = Api.service.findAlbumPhotos(album.id)
                .subscribe(
                        { items ->
                            layout.stateView.state = StateView.LOADED
                            adapter.items = items.toMutableList()
                        },
                        { e ->
                            onError(e)
                        }
                )
    }

    fun Intent.getAlbum(): Album {
        return Parcels.unwrap(getParcelableExtra(EXTRA_ALBUM))
    }

    override fun finish() {
        super.finish()
        request?.dispose()
    }

}