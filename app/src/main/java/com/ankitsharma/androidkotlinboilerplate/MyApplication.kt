package com.ankitsharma.androidkotlinboilerplate

import com.ankitsharma.androidkotlinboilerplate.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by ankitsharma on 11/01/18.
 */
class MyApplication: DaggerApplication() {
    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out MyApplication> {
        return DaggerAppComponent.builder().create(this)
    }
}