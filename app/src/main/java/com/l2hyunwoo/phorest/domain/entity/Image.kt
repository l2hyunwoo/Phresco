package com.l2hyunwoo.phorest.domain.entity

import com.l2hyunwoo.phorest.data.local.entity.ImageEntity
import com.l2hyunwoo.phorest.presentation.model.FeedUiModel

data class Image(
    val id: Int,
    val author: String,
    val width: Int,
    val height: Int,
    val url: String,
    val downloadUrl: String
) {
    fun toImageEntity() = ImageEntity(id, author, width, height, url, downloadUrl)
    fun toFeedUiModel() = FeedUiModel(id, author, width, height, url, downloadUrl)
}
