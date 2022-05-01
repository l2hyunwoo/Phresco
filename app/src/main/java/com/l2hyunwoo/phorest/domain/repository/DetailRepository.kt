package com.l2hyunwoo.phorest.domain.repository

import com.l2hyunwoo.phorest.domain.entity.Image

interface DetailRepository {
    suspend fun loadImageInfo(id: Int): Image
}