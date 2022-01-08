package com.l2hyunwoo.phorest.config.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideBaseUrlStore(baseUrlStoreImpl: BaseUrlStoreImpl): BaseUrlStore = baseUrlStoreImpl
}