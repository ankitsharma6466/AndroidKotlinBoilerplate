package com.ankitsharma.androidkotlinboilerplate.common

import android.arch.lifecycle.Observer
import android.view.View
import dagger.android.support.DaggerAppCompatActivity

/**
 * Created by ankitsharma on 11/01/18.
 */
open class BaseActivity: DaggerAppCompatActivity() {

    fun observeLoader(viewModel: BaseViewModel, loaderView: View) {
        viewModel.loader.observe(this, Observer {
            loaderView.visibility = if(it != null && it) View.VISIBLE else View.GONE
        })
    }
}