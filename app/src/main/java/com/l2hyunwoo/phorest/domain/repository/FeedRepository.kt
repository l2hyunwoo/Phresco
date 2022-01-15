package com.l2hyunwoo.phorest.domain.repository

import com.l2hyunwoo.phorest.domain.entity.Image

interface FeedRepository {
    suspend fun like(image: Image)
    suspend fun dislike(image: Image)
}
