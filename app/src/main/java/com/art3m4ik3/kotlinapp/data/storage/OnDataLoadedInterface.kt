package com.art3m4ik3.kotlinapp.data.storage

interface OnDataLoadedInterface {
    fun onSuccess(data: Any)
    fun onError(message: String)
}