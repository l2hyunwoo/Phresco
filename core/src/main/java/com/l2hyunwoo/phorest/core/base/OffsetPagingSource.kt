package com.l2hyunwoo.phorest.core.base

import androidx.paging.PagingSource
import androidx.paging.PagingState

const val PAGING_PAGE_UNIT = 10

abstract class OffsetPagingSource<V : Any> : PagingSource<Int, V>() {
    override fun getRefreshKey(state: PagingState<Int, V>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}