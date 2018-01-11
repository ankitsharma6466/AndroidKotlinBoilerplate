package com.ankitsharma.androidkotlinboilerplate.di

import com.ankitsharma.androidkotlinboilerplate.MyApplication
import com.ankitsharma.androidkotlinboilerplate.di.modules.ActivityBuilderModule
import com.ankitsharma.androidkotlinboilerplate.di.modules.AppModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created by ankitsharma on 11/01/18.
 */
@Component(modules = arrayOf(AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBuilderModule::class))
interface AppComponent: AndroidInjector<MyApplication> {

    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<MyApplication>()
}