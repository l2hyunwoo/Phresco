package com.l2hyunwoo.phorest.core.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.l2hyunwoo.phorest.core.R
import com.l2hyunwoo.phorest.core.databinding.ItemRecyclerviewStateFooterBinding


class PagingLoadStateAdapter(
    private val retry: () -> Unit
) : LoadStateAdapter<PagingLoadStateAdapter.PagingLoadStateViewHolder>() {
    class PagingLoadStateViewHolder(
        private val binding: ItemRecyclerviewStateFooterBinding,
        retry: () -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.retryButton.setOnClickListener { retry.invoke() }
        }

        fun bind(loadState: LoadState) {
            binding.progressBar.isVisible = loadState is LoadState.Loading
            binding.retryButton.isVisible = loadState is LoadState.Error
            binding.errorTxt.isVisible = loadState is LoadState.Error
        }

        companion object {
            fun create(parent: ViewGroup, retry: () -> Unit): PagingLoadStateViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_recyclerview_state_footer, parent, false)
                val binding = ItemRecyclerviewStateFooterBinding.bind(view)
                return PagingLoadStateViewHolder(binding, retry)
            }
        }
    }

    override fun onBindViewHolder(holder: PagingLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): PagingLoadStateViewHolder = PagingLoadStateViewHolder.create(parent, retry)
}

class ItemDiffCallback<T>(
    val onItemsTheSame: (T, T) -> Boolean,
    val onContentsTheSame: (T, T) -> Boolean
) : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(
        oldItem: T, newItem: T
    ): Boolean = onItemsTheSame(oldItem, newItem)

    override fun areContentsTheSame(
        oldItem: T, newItem: T
    ): Boolean = onContentsTheSame(oldItem, newItem)
}