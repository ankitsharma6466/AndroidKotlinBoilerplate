package com.ankitsharma.androidkotlinboilerplate.di.modules

import com.ankitsharma.androidkotlinboilerplate.data.services.GithubService
import com.ankitsharma.androidkotlinboilerplate.di.annotations.ApplicationScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Provides network services for data
 *
 * Created by ankitsharma on 16/01/18.
 */
@Module(includes = arrayOf(NetworkModule::class))
class NetworkServiceModule {

    @Provides
    @ApplicationScope
    fun provideGithubService(retrofit: Retrofit): GithubService{
        return retrofit.create(GithubService::class.java)
    }
}