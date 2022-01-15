package com.l2hyunwoo.phorest.data.api

import com.l2hyunwoo.phorest.data.model.ImageModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ImageLoadService {
    // 예상 스펙과 달라 이용하지 않음
    @GET("id/{id}/360/760")
    suspend fun loadBlurImage(
        @Path("id") id: Int,
        @Query("blur") blur: Int
    ): ImageModel

    // 예상 스펙과 달라 이용하지 않음
    @GET("id/{id}/360/400")
    suspend fun loadImage(@Path("id") id: Int): ImageModel

    @GET("id/{id}/info")
    suspend fun loadImageInfo(@Path("id") id: Int): ImageModel
}