package com.capsl.miniproject.util.diffcallback

import androidx.recyclerview.widget.DiffUtil
import com.capsl.domain.model.Stage

object StageItemCallback : DiffUtil.ItemCallback<Stage>() {

    override fun areItemsTheSame(oldItem: Stage, newItem: Stage): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Stage, newItem: Stage): Boolean = oldItem == newItem

}