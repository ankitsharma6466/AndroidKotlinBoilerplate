package com.ankitsharma.androidkotlinboilerplate.views.main

import android.arch.lifecycle.MutableLiveData
import com.ankitsharma.androidkotlinboilerplate.common.BaseViewModel
import com.ankitsharma.androidkotlinboilerplate.common.network.ApiObserver
import com.ankitsharma.androidkotlinboilerplate.data.models.ErrorData
import com.ankitsharma.androidkotlinboilerplate.data.models.RepoDTO
import com.ankitsharma.androidkotlinboilerplate.data.models.RepoSearchResponse
import com.ankitsharma.androidkotlinboilerplate.data.repository.DataRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by ankitsharma on 11/01/18.
 */
class MainViewModel @Inject constructor(private val dataRepository: DataRepository) : BaseViewModel() {

    private var msg: String = "test"
    var repoList: MutableLiveData<RepoDTOWrapper> = MutableLiveData()


    private var currentPage = 1
    private var perPage = 20
    private var query : String = ""

    fun getMessage(): String {
        msg = dataRepository.getMessage()
        return msg
    }


    fun start(query: String){
        currentPage = 1
        this.query = query
        searchRepos()
    }

    fun onLoadMore(){
        currentPage++
        searchRepos()
    }

    fun onRefresh(){
        currentPage = 1
        searchRepos()
    }

    private fun searchRepos(){

        loader.value = true

        dataRepository.searchRepositories(query,currentPage,perPage)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : ApiObserver<RepoSearchResponse>(compositeDisposable) {
                    override fun onError(e: ErrorData) {
                        loader.value = false
                        error.value = e
                    }

                    override fun onSuccess(data: RepoSearchResponse) {
                        loader.value = false
                        repoList.value = RepoDTOWrapper(data.repoList,currentPage)
                    }
                })
    }


}

data class RepoDTOWrapper(
        var repoList : List<RepoDTO>,
        var page : Int
)