package com.boilerplate.activity

import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.boilerplate.adapter.AlbumAdapter
import com.boilerplate.api.Api
import com.boilerplate.base.BaseActivity
import com.boilerplate.ui.RecyclerLayout
import com.boilerplate.widget.StateView.Companion.LOADED
import io.reactivex.disposables.Disposable
import org.jetbrains.anko.startActivity
import org.parceler.Parcels

class AlbumActivity : BaseActivity() {

    override val layout = RecyclerLayout()
    var request: Disposable? = null
    val adapter = AlbumAdapter()

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        layout.recyclerView.layoutManager = LinearLayoutManager(this)
        layout.recyclerView.adapter = adapter
        adapter.onCellClickListener = { _, item, _ ->
            startActivity<PhotoActivity>(PhotoActivity.EXTRA_ALBUM to Parcels.wrap(item))
        }
        val startTime = System.currentTimeMillis()
        request = Api.service.findAlbums()
                .subscribe(
                        { items ->
                            layout.stateView.state = LOADED
                            adapter.items = items.toMutableList()
                        },
                        { e ->
                            onError(e)
                        }
                )
        Log.e("Performance", "Speed: " + (System.currentTimeMillis() - startTime) + "ms")
    }

    override fun finish() {
        super.finish()
        request?.dispose()
    }

}