package com.capsl.miniproject.util.diffcallback

import androidx.recyclerview.widget.DiffUtil
import com.capsl.domain.model.Player

object PlayerItemCallback : DiffUtil.ItemCallback<Player>() {
    override fun areItemsTheSame(oldItem: Player, newItem: Player): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Player, newItem: Player): Boolean = oldItem == newItem
}