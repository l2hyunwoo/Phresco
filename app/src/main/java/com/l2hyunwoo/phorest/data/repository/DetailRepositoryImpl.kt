package com.l2hyunwoo.phorest.data.repository

import com.l2hyunwoo.phorest.data.api.ImageLoadService
import com.l2hyunwoo.phorest.domain.entity.Image
import com.l2hyunwoo.phorest.domain.repository.DetailRepository
import javax.inject.Inject

class DetailRepositoryImpl @Inject constructor(
    private val service: ImageLoadService
) : DetailRepository {
    override suspend fun loadImageInfo(id: Int): Image {
        return service.loadImageInfo(id).toImage()
    }
}