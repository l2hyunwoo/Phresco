package com.l2hyunwoo.phorest.config.di

interface BaseUrlStore {
    val picBaseUrl: String
}

class BaseUrlStoreImpl : BaseUrlStore {
    override val picBaseUrl: String = getBaseUrl()

    init {
        System.loadLibrary("baseurl")
    }

    private external fun getBaseUrl(): String
}
