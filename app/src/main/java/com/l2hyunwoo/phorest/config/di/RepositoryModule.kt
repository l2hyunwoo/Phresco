package com.l2hyunwoo.phorest.config.di

import com.l2hyunwoo.phorest.data.repository.FeedRepositoryImpl
import com.l2hyunwoo.phorest.domain.repository.FeedRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideFeedRepository(repository: FeedRepositoryImpl): FeedRepository = repository
}