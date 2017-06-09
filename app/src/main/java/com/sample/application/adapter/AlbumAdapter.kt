package com.sample.application.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.sample.application.R
import com.sample.application.base.BaseAdapter
import com.sample.application.model.Album
import com.sample.application.ui.selectableItemBackgroundResource
import org.jetbrains.anko.*

/**
 * Created by tomykho on 6/2/17.
 */
class AlbumAdapter : BaseAdapter<Album, AlbumAdapter.Cell>() {

    override fun onCreateCell(parent: ViewGroup, viewType: Int): Cell {
        return Cell(parent)
    }

    override fun onBindViewHolder(holder: BaseAdapter.BaseViewHolder<Cell>, position: Int) {
        super.onBindViewHolder(holder, position)
        val item = items[position]
        val cell = holder.cell
        cell.titleTextView.text = item.title
    }

    class Cell(parent: ViewGroup) : BaseCell(parent) {
        lateinit var titleTextView: TextView

        override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
            frameLayout {
                lparams(width = matchParent)
                backgroundResource = selectableItemBackgroundResource
                textView {
                    padding = dimen(R.dimen.content_padding)
                    titleTextView = this
                }
            }
        }
    }

}