package com.ankitsharma.androidkotlinboilerplate.common.network

import com.ankitsharma.androidkotlinboilerplate.data.models.ErrorData
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by ankitsharma on 18/01/18.
 */
abstract class ApiObserver<T> constructor(private val compositeDisposable: CompositeDisposable): Observer<T> {

    override fun onComplete() {

    }

    override fun onSubscribe(d: Disposable) {
        compositeDisposable.add(d)
    }

    override fun onNext(t: T) {
        onSuccess(t)
    }

    override fun onError(e: Throwable) {
        onError(ErrorData(throwable = e, message = e.localizedMessage))
    }

    abstract fun onSuccess(data: T)
    abstract fun onError(e: ErrorData)
}