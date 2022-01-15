package com.l2hyunwoo.phorest.presentation.gallery.subscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.l2hyunwoo.phorest.core.base.PAGING_PAGE_UNIT
import com.l2hyunwoo.phorest.data.api.FeedService
import com.l2hyunwoo.phorest.data.source.FeedPagingSource
import com.l2hyunwoo.phorest.presentation.model.FeedUiModel
import com.l2hyunwoo.phorest.presentation.model.toFeedUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val feedService: FeedService
) : ViewModel() {
    val feedList: Flow<PagingData<FeedUiModel>> = Pager(
        config = PagingConfig(pageSize = PAGING_PAGE_UNIT),
        pagingSourceFactory = { FeedPagingSource(feedService) }
    ).flow.map { pagingData ->
        pagingData.map { it.toFeedUiModel() }
    }.cachedIn(viewModelScope)
}
