package com.boilerplate.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.boilerplate.base.BaseAdapter
import com.boilerplate.model.Photo
import com.boilerplate.ui.squareImageView
import com.boilerplate.ui.url
import org.jetbrains.anko.AnkoContext

/**
 * Created by tomykho on 6/2/17.
 */
class PhotoAdapter : BaseAdapter<Photo, PhotoAdapter.Cell>() {

    override fun onCreateCell(parent: ViewGroup, viewType: Int): Cell {
        return Cell(parent)
    }

    override fun onBindViewHolder(holder: BaseAdapter.BaseViewHolder<Cell>, position: Int) {
        super.onBindViewHolder(holder, position)
        val item = items[position]
        val cell = holder.cell
        cell.imageView.url = item.url
    }

    class Cell(parent: ViewGroup) : BaseCell(parent) {
        lateinit var imageView: ImageView

        override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
            squareImageView {
                imageView = this
            }
        }
    }

}