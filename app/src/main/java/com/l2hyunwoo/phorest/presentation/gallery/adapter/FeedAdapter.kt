package com.l2hyunwoo.phorest.presentation.gallery.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.doOnAttach
import androidx.core.view.doOnDetach
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.l2hyunwoo.phorest.core.view.ItemDiffCallback
import com.l2hyunwoo.phorest.databinding.ItemFeedImageBinding
import com.l2hyunwoo.phorest.presentation.model.FeedUiModel
import kotlinx.coroutines.*

class FeedAdapter(context: Context) : PagingDataAdapter<FeedUiModel, FeedAdapter.FeedViewHolder>(
    ItemDiffCallback(
        onItemsTheSame = { old, new -> old.id == new.id },
        onContentsTheSame = { old, new -> old == new }
    )
) {
    private val inflater = LayoutInflater.from(context)

    class FeedViewHolder(
        private val binding: ItemFeedImageBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        private var coroutineScope: CoroutineScope? = null

        init {
            itemView.doOnAttach {
                coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
            }
            itemView.doOnDetach {
                coroutineScope?.cancel()
                coroutineScope = null
            }
        }

        private suspend fun loadImage(url: String) {
            Glide.with(itemView.context)
                .load(url)
                .override(150, 240)
                .into(binding.imgFeed)
        }

        fun onBind(feed: FeedUiModel) {
            coroutineScope?.launch {
                loadImage(feed.downloadUrl)
            }
        }
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.itemView.doOnAttach {
            getItem(position)?.let { holder.onBind(it) }
            holder.itemView.findViewTreeLifecycleOwner()?.lifecycleScope?.launch {
                if (position <= snapshot().size) {
                    val endPosition =
                        if (position + 10 > snapshot().size) snapshot().size else position + 10
                    snapshot().subList(position, endPosition)
                        .asSequence()
                        .map { it?.downloadUrl }
                        .forEach { url ->
                            Glide.with(holder.itemView.context)
                                .load(url)
                                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                                .preload(150, 240)
                        }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        return FeedViewHolder(ItemFeedImageBinding.inflate(inflater, parent, false))
    }
}