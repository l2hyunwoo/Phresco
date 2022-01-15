package com.l2hyunwoo.phorest.presentation.gallery.subscreen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.l2hyunwoo.phorest.R
import com.l2hyunwoo.phorest.core.base.BindingFragment
import com.l2hyunwoo.phorest.core.view.PagingLoadStateAdapter
import com.l2hyunwoo.phorest.databinding.FragmentFavoriteBinding
import com.l2hyunwoo.phorest.presentation.gallery.adapter.FavoriteAdapter
import com.l2hyunwoo.phorest.presentation.gallery.util.FeedGridItemDecoration
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavoriteFragment : BindingFragment<FragmentFavoriteBinding>(R.layout.fragment_favorite) {
    private var favoriteAdapter: FavoriteAdapter? = null
    private val viewModel by viewModels<FavoriteViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        favoriteAdapter = FavoriteAdapter(requireContext())
        with(binding.rvFavoriteImages) {
            adapter = favoriteAdapter?.withLoadStateFooter(
                footer = PagingLoadStateAdapter { favoriteAdapter?.retry() }
            )
            addItemDecoration(FeedGridItemDecoration(12))
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.favoriteImageList
                .flowWithLifecycle(viewLifecycleOwner.lifecycle)
                .collect { favoriteAdapter?.submitData(it) }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        favoriteAdapter = null
    }
}