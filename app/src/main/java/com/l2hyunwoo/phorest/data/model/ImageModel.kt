package com.l2hyunwoo.phorest.data.model

import com.google.gson.annotations.SerializedName

data class ImageModel(
    val id: Int,
    val author: String,
    val width: Int,
    val height: Int,
    val url: String,
    @SerializedName("download_url")
    val downloadUrl: String
)