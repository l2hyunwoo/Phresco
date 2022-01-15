package com.l2hyunwoo.phorest.presentation.gallery.subscreen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.GAP_HANDLING_NONE
import com.l2hyunwoo.phorest.R
import com.l2hyunwoo.phorest.core.base.BindingFragment
import com.l2hyunwoo.phorest.databinding.FragmentFeedBinding
import com.l2hyunwoo.phorest.presentation.gallery.adapter.FeedAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FeedFragment : BindingFragment<FragmentFeedBinding>(R.layout.fragment_feed) {
    private var feedAdapter: FeedAdapter? = null
    private val viewModel by viewModels<FeedViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        feedAdapter = FeedAdapter(requireContext())
        binding.rvFeedImages.adapter = feedAdapter
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.feedList
                .flowWithLifecycle(viewLifecycleOwner.lifecycle)
                .collect { feedAdapter?.submitData(it) }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        feedAdapter = null
    }
}