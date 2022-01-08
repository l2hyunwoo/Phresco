package com.l2hyunwoo.phorest.config.di

import javax.inject.Inject

interface BaseUrlStore {
    val picBaseUrl: String
}

class BaseUrlStoreImpl @Inject constructor() : BaseUrlStore {
    override val picBaseUrl: String
        get() = getBaseUrl()

    init {
        System.loadLibrary("baseurl")
    }

    private external fun getBaseUrl(): String
}
