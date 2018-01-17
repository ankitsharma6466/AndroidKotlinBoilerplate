package com.ankitsharma.androidkotlinboilerplate.views.main

import android.arch.lifecycle.ViewModel
import com.ankitsharma.androidkotlinboilerplate.data.repository.DataRepository
import javax.inject.Inject

/**
 * Created by ankitsharma on 11/01/18.
 */
class MainViewModel @Inject constructor(val dataRepository: DataRepository): ViewModel() {

    private var msg: String = "test"

    fun getMessage(): String{
        msg = dataRepository.getMessage()
        return msg
    }
}