package com.capsl.miniproject.ui.stages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.capsl.domain.model.Stage
import com.capsl.domain.sealedclass.Resource
import com.capsl.miniproject.R
import com.capsl.miniproject.databinding.FragmentStagesBinding
import com.capsl.miniproject.databinding.ItemStageBinding
import com.capsl.miniproject.util.adapter.SimpleListAdapter
import com.capsl.miniproject.util.base.BaseFragment
import com.capsl.miniproject.util.databinding.withBinding
import com.capsl.miniproject.util.diffcallback.StageItemCallback
import com.capsl.miniproject.util.lifecycle.observeNonNull
import com.capsl.miniproject.util.viewmodel.withViewModel

class StagesFragment : BaseFragment() {

    private lateinit var binding: FragmentStagesBinding
    private lateinit var viewModel: StagesViewModel

    private val adapter = object : SimpleListAdapter<Stage, ItemStageBinding>(StageItemCallback, R.layout.item_stage) {
        override fun bind(holder: ViewHolder<ItemStageBinding>, item: Stage) {
            Glide.with(holder.itemView)
                .load(item.image)
                .placeholder(R.drawable.ic_image_black_24dp)
                .error(R.drawable.ic_image_black_24dp)
                .centerCrop()
                .into(holder.binding.imgStage)
            holder.binding.txtStageTitle.text = item.name
            holder.itemView.setOnClickListener { onStageSelected(item) }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = withBinding(inflater, R.layout.fragment_stages, container)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.apply {
            recyclerView.apply {
                layoutManager = GridLayoutManager(this@StagesFragment.context, 2)
                adapter = this@StagesFragment.adapter
            }
        }
        viewModel = withViewModel(this, viewModelFactory) {
            observeNonNull(getResult(), ::handleStageListResult)
            getStageList()
        }
        binding.swipeRefreshLayout.setOnRefreshListener { viewModel.getStageList() }
    }

    private fun handleStageListResult(resource: Resource<List<Stage>>) {
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

    private fun onStageSelected(stage: Stage) {
        // todo add stage as selected in activity viewmodel
        findNavController().navigate(StagesFragmentDirections.ShowPlayersFragment())
    }


}