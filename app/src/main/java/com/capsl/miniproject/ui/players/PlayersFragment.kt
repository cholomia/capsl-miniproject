package com.capsl.miniproject.ui.players

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.capsl.domain.model.Player
import com.capsl.domain.sealedclass.Resource
import com.capsl.miniproject.R
import com.capsl.miniproject.databinding.FragmentPlayersBinding
import com.capsl.miniproject.databinding.ItemPlayerBinding
import com.capsl.miniproject.databinding.ItemSelectedPlayerBinding
import com.capsl.miniproject.util.adapter.SimpleListAdapter
import com.capsl.miniproject.util.base.BaseFragment
import com.capsl.miniproject.util.databinding.withBinding
import com.capsl.miniproject.util.diffcallback.PlayerItemCallback
import com.capsl.miniproject.util.lifecycle.observeNonNull
import com.capsl.miniproject.util.viewmodel.withViewModel
import timber.log.Timber

class PlayersFragment : BaseFragment() {

    private lateinit var binding: FragmentPlayersBinding
    private lateinit var viewModel: PlayersViewModel

    private val playersAdapter =
        object : SimpleListAdapter<Player, ItemPlayerBinding>(PlayerItemCallback, R.layout.item_player) {
            override fun bind(holder: ViewHolder<ItemPlayerBinding>, item: Player) {
                Glide.with(holder.itemView)
                    .load(item.profile?.image)
                    .placeholder(R.drawable.ic_person_black_24dp)
                    .error(R.drawable.ic_person_black_24dp)
                    .circleCrop()
                    .into(holder.binding.imgPlayer)
                holder.binding.txtPlayer.text = item.profile?.fullName

                holder.binding.btnSelectPlayer.setImageResource(
                    when {
                        item.isSelected -> R.drawable.ic_remove_circle_black_24dp
                        else -> R.drawable.ic_add_circle_black_24dp
                    }
                )
                holder.binding.btnSelectPlayer.setOnClickListener { onPlayerSelected(item) }
            }
        }

    private val selectedPlayersAdapter = object :
        SimpleListAdapter<Player, ItemSelectedPlayerBinding>(PlayerItemCallback, R.layout.item_selected_player) {
        override fun bind(holder: ViewHolder<ItemSelectedPlayerBinding>, item: Player) {
            Glide.with(holder.itemView)
                .load(item.profile?.image)
                .placeholder(R.drawable.ic_person_black_24dp)
                .error(R.drawable.ic_person_black_24dp)
                .circleCrop()
                .into(holder.binding.imgPlayer)
            holder.binding.btnSelectPlayer.setOnClickListener { onPlayerSelected(item) }
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = withBinding(inflater, R.layout.fragment_players, container)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.apply {
            recyclerViewPlayers.apply {
                layoutManager = LinearLayoutManager(this@PlayersFragment.context)
                adapter = playersAdapter
                addItemDecoration(DividerItemDecoration(this@PlayersFragment.context, DividerItemDecoration.VERTICAL))
            }
            recyclerViewSelectedPlayer.apply {
                layoutManager = LinearLayoutManager(this@PlayersFragment.context, LinearLayoutManager.HORIZONTAL, false)
                adapter = selectedPlayersAdapter
            }
        }
        viewModel = withViewModel(this, viewModelFactory) {
            observeNonNull(getResult(), ::handlePlayerListResult)
            getPlayerList()
        }
        binding.btnDone.setOnClickListener {
            Toast.makeText(this.context, "TODO: next screen", Toast.LENGTH_LONG).show()
        }
    }

    private fun handlePlayerListResult(resource: Resource<List<Player>>) {
        when (resource) {
            is Resource.Loading -> {
                Timber.d("do some loading stuff")
            }
            is Resource.Success -> {
                val selectedPlayers = resource.data.filter { it.isSelected }
                binding.txtSelectedPlayerHeader.text = "Add to the new tournament ${selectedPlayers.size}"
                playersAdapter.submitList(resource.data)
                selectedPlayersAdapter.submitList(selectedPlayers)
            }
            is Resource.Error -> {
                Toast.makeText(context, resource.error.localizedMessage, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun onPlayerSelected(player: Player) {
        viewModel.changePlayerSelectedStatus(player)
    }

}