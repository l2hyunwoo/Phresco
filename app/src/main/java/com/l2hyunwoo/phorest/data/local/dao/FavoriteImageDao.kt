package com.l2hyunwoo.phorest.data.local.dao

import androidx.room.*
import com.l2hyunwoo.phorest.data.local.entity.ImageEntity

@Dao
interface FavoriteImageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplace(image: ImageEntity)

    @Delete
    suspend fun delete(image: ImageEntity)

    @Query("select * from favorite_image order by id DESC LIMIT :loadSize OFFSET :index * :loadSize")
    suspend fun loadImages(index: Int, loadSize: Int): List<ImageEntity>
}