package com.l2hyunwoo.phorest.config.di

import com.l2hyunwoo.phorest.data.api.FeedService
import com.l2hyunwoo.phorest.data.api.ImageLoadService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun provideFeedService(retrofit: Retrofit): FeedService =
        retrofit.create(FeedService::class.java)

    @Provides
    @Singleton
    fun provideImageLoadService(retrofit: Retrofit): ImageLoadService =
        retrofit.create(ImageLoadService::class.java)
}