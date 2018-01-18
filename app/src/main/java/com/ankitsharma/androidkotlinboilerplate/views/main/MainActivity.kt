package com.ankitsharma.androidkotlinboilerplate.views.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.widget.Toast
import com.ankitsharma.androidkotlinboilerplate.R
import com.ankitsharma.androidkotlinboilerplate.common.BaseActivity
import timber.log.Timber
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        Toast.makeText(this, mainViewModel.getMessage(), Toast.LENGTH_SHORT).show()

        observeSearchResults()

        //init a query
        mainViewModel.searchRepos("android")
    }

    private fun observeSearchResults() {
        mainViewModel.repoList.observe(this, Observer {
            Timber.i("repo count received  ${it?.size}")
        })
    }
}
