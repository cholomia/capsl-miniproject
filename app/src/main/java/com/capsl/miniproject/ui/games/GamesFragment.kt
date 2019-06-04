package com.capsl.miniproject.ui.games

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.capsl.domain.model.Game
import com.capsl.domain.sealedclass.Resource
import com.capsl.miniproject.R
import com.capsl.miniproject.databinding.FragmentGamesBinding
import com.capsl.miniproject.databinding.ItemGameBinding
import com.capsl.miniproject.util.adapter.SimpleListAdapter
import com.capsl.miniproject.util.base.BaseFragment
import com.capsl.miniproject.util.databinding.withBinding
import com.capsl.miniproject.util.diffcallback.GameItemCallback
import com.capsl.miniproject.util.lifecycle.observeNonNull
import com.capsl.miniproject.util.viewmodel.withViewModel

class GamesFragment : BaseFragment() {

    private lateinit var binding: FragmentGamesBinding
    private lateinit var viewModel: GamesViewModel

    private val adapter = object : SimpleListAdapter<Game, ItemGameBinding>(GameItemCallback, R.layout.item_game) {
        override fun bind(holder: ViewHolder<ItemGameBinding>, item: Game) {
            Glide.with(holder.itemView)
                .load(item.image)
                .placeholder(R.drawable.ic_image_black_24dp)
                .error(R.drawable.ic_image_black_24dp)
                .centerCrop()
                .into(holder.binding.imgGame)
            holder.binding.txtGameTitle.text = item.name
            holder.itemView.setOnClickListener { onGameSelected(item) }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = withBinding(inflater, R.layout.fragment_games, container)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.apply {
            recyclerView.apply {
                layoutManager = GridLayoutManager(this@GamesFragment.context, 2)
                adapter = this@GamesFragment.adapter
            }
        }
        viewModel = withViewModel(this, viewModelFactory) {
            observeNonNull(getResult(), ::handleGameListResult)
            getGameList()
        }
        binding.swipeRefreshLayout.setOnRefreshListener { viewModel.getGameList() }
    }

    private fun handleGameListResult(resource: Resource<List<Game>>) {
        when (resource) {
            is Resource.Loading -> {
                binding.swipeRefreshLayout.isRefreshing = true
            }
            is Resource.Success -> {
                binding.swipeRefreshLayout.isRefreshing = false
                adapter.submitList(resource.data)
            }
            is Resource.Error -> {
                binding.swipeRefreshLayout.isRefreshing = false
                Toast.makeText(context, resource.error.localizedMessage, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun onGameSelected(game: Game) {
        // todo post selected game on activity viewmodel for future reference
        findNavController().navigate(GamesFragmentDirections.showStagesFragment())
    }

}