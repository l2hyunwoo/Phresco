package com.l2hyunwoo.phorest.data.api

import com.l2hyunwoo.phorest.data.model.ImageModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ImageLoadService {
    @GET("id/{id}/info")
    suspend fun loadImageInfo(@Path("id") id: Int): ImageModel
}