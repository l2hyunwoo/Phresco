package com.l2hyunwoo.phorest.presentation.gallery.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.l2hyunwoo.phorest.core.view.ItemDiffCallback
import com.l2hyunwoo.phorest.databinding.ItemFeedImageBinding
import com.l2hyunwoo.phorest.presentation.model.FeedUiModel

class FeedAdapter(
    context: Context
) : PagingDataAdapter<FeedUiModel, FeedAdapter.FeedViewHolder>(ItemDiffCallback(
    onItemsTheSame = { old, new -> old.id == new.id },
    onContentsTheSame = { old, new -> old == new }
)) {
    private val inflater = LayoutInflater.from(context)

    class FeedViewHolder(
        private val binding: ItemFeedImageBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(feed: FeedUiModel) {
            Glide.with(itemView.context)
                .load(feed.downloadUrl)
                .into(binding.imgFeed)
        }
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        return FeedViewHolder(ItemFeedImageBinding.inflate(inflater, parent, false))
    }
}