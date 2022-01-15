package com.l2hyunwoo.phorest.presentation.model

import com.l2hyunwoo.phorest.data.model.ImageModel
import com.l2hyunwoo.phorest.domain.entity.Image

data class FeedUiModel(
    val id: Int,
    val author: String,
    val width: Int,
    val height: Int,
    val url: String,
    val downloadUrl: String
) {
    fun toImage() = Image(id, author, width, height, url, downloadUrl)
}

fun ImageModel.toFeedUiModel() = FeedUiModel(id, author, width, height, url, downloadUrl)
