package com.l2hyunwoo.phorest.data.repository

import com.l2hyunwoo.phorest.data.local.dao.FavoriteImageDao
import com.l2hyunwoo.phorest.domain.entity.Image
import com.l2hyunwoo.phorest.domain.entity.toImageEntity
import com.l2hyunwoo.phorest.domain.repository.FeedRepository
import javax.inject.Inject

class FeedRepositoryImpl @Inject constructor(
    private val dao: FavoriteImageDao
) : FeedRepository {
    override suspend fun like(image: Image) {
        dao.insertOrReplace(image.toImageEntity())
    }

    override suspend fun dislike(image: Image) {
        dao.delete(image.toImageEntity())
    }
}