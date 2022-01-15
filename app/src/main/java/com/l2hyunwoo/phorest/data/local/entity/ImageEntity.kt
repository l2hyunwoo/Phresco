package com.l2hyunwoo.phorest.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.l2hyunwoo.phorest.presentation.model.FeedUiModel

@Entity(tableName = "favorite_image")
data class ImageEntity(
    val imageId: Int,
    val author: String,
    val width: Int,
    val height: Int,
    val url: String,
    @ColumnInfo(name = "download_url") val downloadUrl: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    fun toFeedUiModel() = FeedUiModel(imageId, author, width, height, url, downloadUrl)
}
