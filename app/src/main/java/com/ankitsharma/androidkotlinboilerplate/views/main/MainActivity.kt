package com.ankitsharma.androidkotlinboilerplate.views.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.ankitsharma.androidkotlinboilerplate.R
import com.ankitsharma.androidkotlinboilerplate.common.BaseActivity
import com.ankitsharma.androidkotlinboilerplate.views.stuff.adapter.RepoAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var mainViewModel: MainViewModel

    lateinit var mRepoAdapter : RepoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        observeSearchResults()

        //init a query
        mainViewModel.start("android")
        srl_container.setOnRefreshListener {
            mainViewModel.onRefresh()
        }
    }

    private fun initViews() {
        mRepoAdapter = RepoAdapter()
        mRepoAdapter.onLoadMoreListener = object : RepoAdapter.OnLoadMoreListener{
            override fun onLoadMore() {
                mainViewModel.onLoadMore()
            }
        }
        rv_content.adapter = mRepoAdapter
        rv_content.layoutManager = LinearLayoutManager(this)
    }

    private fun observeSearchResults() {
        mainViewModel.repoList.observe(this, Observer {
            if(it?.page==1) mRepoAdapter.resetItems(it?.repoList)
            else mRepoAdapter.addItems(it?.repoList)
        })

        mainViewModel.loader.observe(this, Observer {
            if(it == false) srl_container.isRefreshing = false

            if(it == true && !srl_container.isRefreshing)
                pb_loading.visibility = View.VISIBLE
            else
                pb_loading.visibility = View.GONE
        })
    }

}
