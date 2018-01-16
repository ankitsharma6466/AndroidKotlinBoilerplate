package com.ankitsharma.androidkotlinboilerplate.di.modules

import com.ankitsharma.androidkotlinboilerplate.data.services.GithubService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by ankitsharma on 16/01/18.
 */
@Module(includes = arrayOf(NetworkModule::class))
class NetworkServiceModule {

    @Provides
    @Singleton
    fun provideGithubService(retrofit: Retrofit): GithubService{
        return retrofit.create(GithubService::class.java)
    }
}