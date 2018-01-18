package com.ankitsharma.androidkotlinboilerplate.views.main

import android.arch.lifecycle.LiveData
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
    var repoList: MutableLiveData<List<RepoDTO>> = MutableLiveData()

    fun getMessage(): String {
        msg = dataRepository.getMessage()
        return msg
    }

    fun searchRepos(query: String){

        displayLoader(true)

        dataRepository.searchRepositories(query)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : ApiObserver<RepoSearchResponse>(compositeDisposable) {
                    override fun onError(e: ErrorData) {
                        displayLoader(false)
                        error.value = e
                    }

                    override fun onSuccess(data: RepoSearchResponse) {
                        displayLoader(false)
                        repoList.value = data.repoList
                    }
                })
    }
}