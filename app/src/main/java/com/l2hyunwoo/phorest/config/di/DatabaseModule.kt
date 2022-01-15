package com.l2hyunwoo.phorest.config.di

import android.content.Context
import com.l2hyunwoo.phorest.data.local.dao.FavoriteImageDao
import com.l2hyunwoo.phorest.data.local.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.buildDatabase(context)
    }

    @Provides
    @Singleton
    fun provideFavoriteImageDao(database: AppDatabase): FavoriteImageDao =
        database.favoriteImageDao()
}