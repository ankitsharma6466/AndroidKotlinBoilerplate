package com.ankitsharma.androidkotlinboilerplate.di

import com.ankitsharma.androidkotlinboilerplate.views.main.MainActivity
import com.ankitsharma.androidkotlinboilerplate.views.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * Created by ankitsharma on 11/01/18.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity(): MainActivity
}