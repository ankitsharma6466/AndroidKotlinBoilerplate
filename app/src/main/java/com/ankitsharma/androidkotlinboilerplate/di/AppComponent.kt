package com.ankitsharma.androidkotlinboilerplate.di

import com.ankitsharma.androidkotlinboilerplate.MyApplication
import com.ankitsharma.androidkotlinboilerplate.di.annotations.ApplicationScope
import com.ankitsharma.androidkotlinboilerplate.di.modules.ActivityBuilderModule
import com.ankitsharma.androidkotlinboilerplate.di.modules.AppModule
import com.ankitsharma.androidkotlinboilerplate.di.modules.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Main application component that connects all the dependency providers(modules) to application
 *
 * Created by ankitsharma on 11/01/18.
 */
@ApplicationScope
@Component(modules = arrayOf(AndroidSupportInjectionModule::class,
        AppModule::class,
        ViewModelModule::class,
        ActivityBuilderModule::class))
interface AppComponent: AndroidInjector<MyApplication> {

    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<MyApplication>()
}