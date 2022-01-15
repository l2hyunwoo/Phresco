package com.l2hyunwoo.phorest.data.api

import com.l2hyunwoo.phorest.data.model.ImageModel
import retrofit2.http.GET
import retrofit2.http.Query

interface FeedService {
    @GET("list")
    suspend fun retrieveFeedList(
        @Query("page") page: Int,
        @Query("limit") limit: Int = 10
    ): List<ImageModel>
}