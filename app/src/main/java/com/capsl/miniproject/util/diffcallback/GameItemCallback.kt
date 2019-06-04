package com.capsl.miniproject.util.diffcallback

import androidx.recyclerview.widget.DiffUtil
import com.capsl.domain.model.Game

object GameItemCallback : DiffUtil.ItemCallback<Game>() {
    override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean = oldItem == newItem
}