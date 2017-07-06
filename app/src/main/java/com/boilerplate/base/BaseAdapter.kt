package com.boilerplate.base

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext

abstract class BaseAdapter<M, C : BaseAdapter.BaseCell> : RecyclerView.Adapter<BaseAdapter.BaseViewHolder<C>>() {

    var items: MutableList<M> = mutableListOf()
        set(v) {
            field = v
            notifyDataSetChanged()
        }
    var onCellClickListener: ((C, M, Int) -> Unit)? = null

    init {
        this.setHasStableIds(true)
    }

    fun add(item: M) {
        items.add(item)
        notifyItemInserted(items.size - 1)
    }

    fun add(position: Int, item: M) {
        items.add(position, item)
        notifyItemInserted(position)
    }

    fun addAll(items: List<M>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun clear() {
        items.clear()
        notifyDataSetChanged()
    }

    fun remove(position: Int) {
        items.removeAt(position)
        if (position == 0)
            notifyDataSetChanged()
        else
            notifyItemRemoved(position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseAdapter.BaseViewHolder<C> {
        return BaseViewHolder(onCreateCell(parent, viewType))
    }

    abstract fun onCreateCell(parent: ViewGroup, viewType: Int): C

    override fun onBindViewHolder(holder: BaseAdapter.BaseViewHolder<C>, position: Int) {
        val onCellClickListener = onCellClickListener
        if (onCellClickListener != null) {
            holder.itemView.setOnClickListener {
                val adapterPosition = holder.adapterPosition
                onCellClickListener.invoke(holder.cell, items[adapterPosition], adapterPosition)
            }
        }
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    class BaseViewHolder<out C : BaseCell>(val cell: C) : RecyclerView.ViewHolder(cell.itemView)

    abstract class BaseCell(parent: ViewGroup) : AnkoComponent<ViewGroup> {

        var itemView: View? = null

        init {
            itemView = this.createView(AnkoContext.Companion.create(parent.context, parent))
        }
    }

}