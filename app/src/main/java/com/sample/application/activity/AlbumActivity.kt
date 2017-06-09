package com.sample.application.activity

import android.support.v7.widget.LinearLayoutManager
import com.sample.application.adapter.AlbumAdapter
import com.sample.application.api.Api
import com.sample.application.base.BaseActivity
import com.sample.application.ui.RecyclerLayout
import com.sample.application.widget.StateView.Companion.LOADED
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
    }

    override fun finish() {
        super.finish()
        request?.dispose()
    }

}