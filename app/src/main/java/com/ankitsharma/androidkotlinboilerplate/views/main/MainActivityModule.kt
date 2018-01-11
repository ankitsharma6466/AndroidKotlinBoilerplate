package com.ankitsharma.androidkotlinboilerplate.views.main

import dagger.Module

/**
 * Created by ankitsharma on 11/01/18.
 */
@Module
class MainActivityModule {

    fun provideMessage(): String = "hello"
}