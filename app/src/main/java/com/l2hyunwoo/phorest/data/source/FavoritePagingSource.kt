package com.l2hyunwoo.phorest.data.source

import com.l2hyunwoo.phorest.core.base.OffsetPagingSource
import com.l2hyunwoo.phorest.data.local.dao.FavoriteImageDao
import com.l2hyunwoo.phorest.data.local.entity.ImageEntity

private const val INIT_PAGE_INDEX = 0

class FavoritePagingSource(private val dao: FavoriteImageDao) : OffsetPagingSource<ImageEntity>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ImageEntity> {
        val position = params.key ?: INIT_PAGE_INDEX
        val loadData = dao.loadImages(position, params.loadSize)
        return LoadResult.Page(
            data = loadData,
            prevKey = if (position == INIT_PAGE_INDEX) null else position - 1,
            nextKey = if (loadData.isNullOrEmpty()) null else position + 1
        )
    }
}