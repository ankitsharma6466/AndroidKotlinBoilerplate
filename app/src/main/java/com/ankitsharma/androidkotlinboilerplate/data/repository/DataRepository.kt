package com.ankitsharma.androidkotlinboilerplate.data.repository

import com.ankitsharma.androidkotlinboilerplate.di.annotations.ApplicationScope
import javax.inject.Inject

/**
 * Created by ankitsharma on 11/01/18.
 */
@ApplicationScope
class DataRepository @Inject constructor(){

    fun getMessage(): String {
        return "hello my message"
    }
}