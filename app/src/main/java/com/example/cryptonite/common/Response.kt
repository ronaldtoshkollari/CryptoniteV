package com.example.cryptonite.common

sealed class Response<T>(val data: T? = null, val message: String? = null){
    class Success<T>(data: T?): Response<T>(data)
    class Loading<T>(data: T?= null): Response<T>(data)
    class Error<T>(data: T? = null, message: String?): Response<T>(data, message)
}
