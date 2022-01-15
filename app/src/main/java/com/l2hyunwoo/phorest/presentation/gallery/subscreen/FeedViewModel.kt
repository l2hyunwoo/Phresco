package com.l2hyunwoo.phorest.presentation.gallery.subscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.l2hyunwoo.phorest.core.base.PAGING_PAGE_UNIT
import com.l2hyunwoo.phorest.data.api.FeedService
import com.l2hyunwoo.phorest.data.source.FeedPagingSource
import com.l2hyunwoo.phorest.domain.repository.FeedRepository
import com.l2hyunwoo.phorest.presentation.model.FeedUiModel
import com.l2hyunwoo.phorest.presentation.model.toFeedUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val feedService: FeedService,
    private val feedRepository: FeedRepository
) : ViewModel() {
    val feedList: Flow<PagingData<FeedUiModel>> = Pager(
        config = PagingConfig(pageSize = PAGING_PAGE_UNIT),
        pagingSourceFactory = { FeedPagingSource(feedService) }
    ).flow.map { pagingData ->
        pagingData.map { it.toFeedUiModel() }
    }.cachedIn(viewModelScope)

    fun like(feedUiModel: FeedUiModel) {
        viewModelScope.launch {
            feedRepository.like(feedUiModel.toImage())
        }
    }

    fun dislike(feedUiModel: FeedUiModel) {
        viewModelScope.launch {
            feedRepository.dislike(feedUiModel.toImage())
        }
    }
}
