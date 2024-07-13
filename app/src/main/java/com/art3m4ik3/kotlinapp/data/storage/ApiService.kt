package com.art3m4ik3.kotlinapp.data.storage

import com.art3m4ik3.kotlinapp.data.models.RegisterResponse
import com.art3m4ik3.kotlinapp.data.models.LoginRequest
import com.art3m4ik3.kotlinapp.data.models.LoginResponse
import com.art3m4ik3.kotlinapp.data.models.RegisterRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService { // интерфейс для прописывания маршрутов и запросов
    @POST("login") // post запрос
    fun login(@Body request: LoginRequest): Call<LoginResponse> // обьявление метода для отправки данных

    @POST("register") // post запрос
    fun register(@Body request: RegisterRequest): Call<RegisterResponse> // обьявление метода для отправки данных
}
