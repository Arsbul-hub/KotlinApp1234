package com.art3m4ik3.kotlinapp.data.storage

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    val retrofitBuilder = Retrofit.Builder()
        .baseUrl("https://arsbul.pythonanywhere.com/") // установка url
        .addConverterFactory(GsonConverterFactory.create()) // инициализация конвертера из json в data class. Она привязывается к retrofit.Builder
        .build()
    val apiService: ApiService =
        retrofitBuilder.create(ApiService::class.java) // инициализация маршрутов для получения данных

}
