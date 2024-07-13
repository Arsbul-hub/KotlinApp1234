package com.art3m4ik3.kotlinapp.domain

import android.content.SharedPreferences
import com.art3m4ik3.kotlinapp.data.models.LoginRequest
import com.art3m4ik3.kotlinapp.data.models.LoginResponse
import com.art3m4ik3.kotlinapp.data.models.RegisterRequest
import com.art3m4ik3.kotlinapp.data.models.RegisterResponse
import com.art3m4ik3.kotlinapp.data.storage.OnDataLoadedInterface
import com.art3m4ik3.kotlinapp.data.storage.RetrofitHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthApi(val sharedPreferences: SharedPreferences) {

    fun login(username: String, password: String, callback: OnDataLoadedInterface) {
        val request = LoginRequest(username, password) // создание структуры запроса
        RetrofitHelper.apiService.login(request).enqueue(object :
            Callback<LoginResponse> { // вызов метода отправки post запроса на получение данных асинхронно
            override fun onResponse(
                call: Call<LoginResponse>,
                response: Response<LoginResponse>
            ) { // обработка ответа
                val body = response.body() // получение body ответа
                if (body != null && body.status == "success") { // если ответ не пустой и успешен
                    callback.onSuccess(body)
                    val edit = sharedPreferences.edit()
                    edit.putString("token", body.token)
                    edit.putString("username", username)
                    edit.apply()
                } else {
                    callback.onError("Ошибка")

                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) { // обработка ошибки
                callback.onError("Ошибка обработки запроса: ${t.message}")
            }
        })
    }

    fun register(username: String, password: String, callback: OnDataLoadedInterface) {
        val request = RegisterRequest(username, password, "") // создание структуры запроса
        RetrofitHelper.apiService.register(request).enqueue(object :
            Callback<RegisterResponse> { // вызов метода отправки post запроса на получение данных асинхронно
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) { // обработка ответа
                val body = response.body() // получение body ответа
                if (body != null && body.status == "success") { // если ответ не пустой и успешен
                    callback.onSuccess(body)
                    val edit = sharedPreferences.edit()
                    edit.putString("token", body.token)
                    edit.putString("username", username)
                    edit.apply()
                } else {
                    callback.onError("Ошибка")
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) { // обработка ошибки
                callback.onError("Ошибка обработки запроса: ${t.message}")
            }
        })
    }
}