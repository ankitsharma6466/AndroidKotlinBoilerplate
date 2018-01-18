package com.ankitsharma.androidkotlinboilerplate.data.models

/**
 * Created by ankitsharma on 18/01/18.
 */
class ErrorData(message: String = "", errorCode: String = "", throwable: Throwable? = null) {
    var message: String = message
    var errorCode: String = errorCode
    var throwable: Throwable? = throwable
}