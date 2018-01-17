package com.ankitsharma.androidkotlinboilerplate.di.modules

import android.app.Application
import android.content.Context
import com.ankitsharma.androidkotlinboilerplate.di.annotations.ApplicationScope
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * App level dependencies
 * Created by ankitsharma on 11/01/18.
 */
@Module(includes = arrayOf(NetworkServiceModule::class))
class AppModule {

    @Provides
    @ApplicationScope
    fun provideContext(application: Application): Context = application
}