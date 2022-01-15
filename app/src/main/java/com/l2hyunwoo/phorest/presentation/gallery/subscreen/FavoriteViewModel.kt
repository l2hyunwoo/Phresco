package com.l2hyunwoo.phorest.presentation.gallery.subscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.l2hyunwoo.phorest.core.base.PAGING_PAGE_UNIT
import com.l2hyunwoo.phorest.data.local.dao.FavoriteImageDao
import com.l2hyunwoo.phorest.data.source.FavoritePagingSource
import com.l2hyunwoo.phorest.presentation.model.FeedUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val dao: FavoriteImageDao
) : ViewModel() {
    val favoriteImageList: Flow<PagingData<FeedUiModel>> = Pager(
        config = PagingConfig(pageSize = PAGING_PAGE_UNIT),
        pagingSourceFactory = { FavoritePagingSource(dao) }
    ).flow.map { pagingData ->
        pagingData.map { it.toFeedUiModel() }
    }.cachedIn(viewModelScope)
}