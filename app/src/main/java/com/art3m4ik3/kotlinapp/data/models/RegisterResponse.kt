package com.art3m4ik3.kotlinapp.data.models

data class RegisterResponse( // структура получаемых данных
    val status: String,
    val token: String?,
    val code: Int?,
    val message: String?
)
