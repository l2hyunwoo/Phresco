package com.l2hyunwoo.phorest.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.l2hyunwoo.phorest.data.local.dao.FavoriteImageDao
import com.l2hyunwoo.phorest.data.local.entity.ImageEntity

@Database(entities = [ImageEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteImageDao(): FavoriteImageDao

    companion object {
        private const val DATABASE_NAME = "cache.db"

        fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                DATABASE_NAME
            ).build()
        }
    }
}