package com.boilerplate.activity

import android.content.Intent
import android.support.v7.widget.GridLayoutManager
import com.boilerplate.adapter.PhotoAdapter
import com.boilerplate.api.Api
import com.boilerplate.base.BaseActivity
import com.boilerplate.model.Album
import com.boilerplate.ui.RecyclerLayout
import com.boilerplate.widget.StateView
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