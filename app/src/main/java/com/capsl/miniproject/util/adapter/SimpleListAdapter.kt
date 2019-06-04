package com.capsl.miniproject.util.adapter

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.capsl.miniproject.util.databinding.withBinding

abstract class SimpleListAdapter<T, B : ViewDataBinding>(
    diffCallback: DiffUtil.ItemCallback<T>,
    @LayoutRes private val layout: Int
) : ListAdapter<T, SimpleListAdapter.ViewHolder<B>>(diffCallback) {

    abstract fun bind(holder: ViewHolder<B>, item: T)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<B> =
        ViewHolder(parent.withBinding(layout))

    override fun onBindViewHolder(holder: ViewHolder<B>, position: Int) {
        bind(holder, getItem(position))
        holder.binding.executePendingBindings()
    }

    class ViewHolder<B : ViewDataBinding>(val binding: B) : RecyclerView.ViewHolder(binding.root)

}