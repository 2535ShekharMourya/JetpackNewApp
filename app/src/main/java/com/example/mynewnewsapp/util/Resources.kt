package com.example.mynewnewsapp.util

sealed class Resources<T>(val data:T? = null,val message:String? = null) {
    class Success<T>(data: T?):Resources<T>(data=data)
    class Error<T>(message: String?):Resources<T>(message=message)
}