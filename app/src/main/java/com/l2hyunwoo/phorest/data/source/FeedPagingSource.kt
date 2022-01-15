package com.l2hyunwoo.phorest.data.source

import com.l2hyunwoo.phorest.core.base.OffsetPagingSource
import com.l2hyunwoo.phorest.data.api.FeedService
import com.l2hyunwoo.phorest.data.model.ImageModel

private const val START_POSITION_INDEX = 1

class FeedPagingSource(private val service: FeedService) : OffsetPagingSource<ImageModel>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ImageModel> {
        val currentPosition = params.key ?: START_POSITION_INDEX

        val response = runCatching { service.retrieveFeedList(currentPosition) }
            .getOrElse { return LoadResult.Error(it) }

        val nextPositon = currentPosition + 1
        val previousPosition =
            if (currentPosition != START_POSITION_INDEX) null else currentPosition - 1
        return runCatching {
            LoadResult.Page(
                data = response,
                prevKey = previousPosition,
                nextKey = nextPositon
            )
        }.getOrElse { LoadResult.Error(it) }
    }
}