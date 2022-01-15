package com.l2hyunwoo.phorest.domain.repository

import com.l2hyunwoo.phorest.domain.entity.Image

interface DetailRepository {
    suspend fun loadBlurImage(id: Int, blur: Int = 2): Image
    suspend fun loadImage(id: Int): Image
    suspend fun loadImageInfo(id: Int): Image
}