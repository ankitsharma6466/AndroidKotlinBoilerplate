package com.ankitsharma.androidkotlinboilerplate.di.modules

import com.ankitsharma.androidkotlinboilerplate.common.MyViewModelFactory
import com.ankitsharma.androidkotlinboilerplate.di.ViewModelKey
import com.ankitsharma.androidkotlinboilerplate.views.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by ankitsharma on 11/01/18.
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel)

    @Binds
    abstract fun bindViewModelFactory(factory: MyViewModelFactory)
}