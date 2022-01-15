package com.l2hyunwoo.phorest.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_image")
data class ImageEntity(
    @PrimaryKey val id: Int,
    val author: String,
    val width: Int,
    val height: Int,
    val url: String,
    @ColumnInfo(name = "download_url") val downloadUrl: String
)
