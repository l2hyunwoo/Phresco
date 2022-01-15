package com.l2hyunwoo.phorest.data.api

import com.l2hyunwoo.phorest.core.base.PAGING_PAGE_UNIT
import com.l2hyunwoo.phorest.data.model.ImageModel
import retrofit2.http.GET
import retrofit2.http.Query

interface FeedService {
    @GET("v2/list")
    suspend fun retrieveFeedList(
        @Query("page") page: Int,
        @Query("limit") limit: Int = PAGING_PAGE_UNIT
    ): List<ImageModel>
}