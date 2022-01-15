package com.l2hyunwoo.phorest.data.repository

import com.l2hyunwoo.phorest.data.api.ImageLoadService
import com.l2hyunwoo.phorest.domain.entity.Image
import com.l2hyunwoo.phorest.domain.repository.DetailRepository
import javax.inject.Inject

class DetailRepositoryImpl @Inject constructor(
    private val service: ImageLoadService
) : DetailRepository {
    override suspend fun loadBlurImage(id: Int, blur: Int): Image {
        return service.loadBlurImage(id, 2).toImage()
    }

    override suspend fun loadImage(id: Int): Image {
        return service.loadImage(id).toImage()
    }

    override suspend fun loadImageInfo(id: Int): Image {
        return service.loadImageInfo(id).toImage()
    }
}