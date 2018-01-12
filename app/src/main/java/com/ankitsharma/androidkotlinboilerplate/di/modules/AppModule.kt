package com.ankitsharma.androidkotlinboilerplate.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by ankitsharma on 11/01/18.
 */
@Module(includes = arrayOf(NetworkModule::class, ViewModelModule::class))
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application
}