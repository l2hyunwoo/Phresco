package com.l2hyunwoo.phorest.presentation.gallery.subscreen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.l2hyunwoo.phorest.R
import com.l2hyunwoo.phorest.core.base.BindingFragment
import com.l2hyunwoo.phorest.core.fragment.snackBar
import com.l2hyunwoo.phorest.core.fragment.toast
import com.l2hyunwoo.phorest.core.view.PagingLoadStateAdapter
import com.l2hyunwoo.phorest.databinding.FragmentFeedBinding
import com.l2hyunwoo.phorest.presentation.detail.DetailActivity
import com.l2hyunwoo.phorest.presentation.gallery.adapter.FeedAdapter
import com.l2hyunwoo.phorest.presentation.gallery.util.FeedGridItemDecoration
import com.l2hyunwoo.phorest.presentation.model.FeedUiModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FeedFragment : BindingFragment<FragmentFeedBinding>(R.layout.fragment_feed) {
    private var feedAdapter: FeedAdapter? = null
    private val viewModel by viewModels<FeedViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val feedAdapterCallback = object : FeedAdapter.Callback {
            override fun like(feed: FeedUiModel) {
                viewModel.like(feed)
                snackBar(binding.root) { "Like It ❤️" }
            }

            override fun rootClick(id: Int) {
                startActivity(DetailActivity.getIntent(requireContext(), id))
            }
        }

        feedAdapter = FeedAdapter(requireContext(), feedAdapterCallback)
        with(binding.rvFeedImages) {
            adapter = feedAdapter?.withLoadStateFooter(
                footer = PagingLoadStateAdapter { feedAdapter?.retry() }
            )
            addItemDecoration(FeedGridItemDecoration(12))
        }
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