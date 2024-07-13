package com.art3m4ik3.kotlinapp.presentation.pages

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.art3m4ik3.kotlinapp.databinding.ActivitySignupFormBinding
import com.art3m4ik3.kotlinapp.data.storage.OnDataLoadedInterface
import com.art3m4ik3.kotlinapp.domain.AuthApi

class SignupForm : AppCompatActivity() {
    lateinit var binding: ActivitySignupFormBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("AuthData", MODE_PRIVATE)
        val authApi = AuthApi(sharedPreferences)
        if (sharedPreferences.getString("token", "") != "") {
            startActivity(Intent(this, HolderActivity::class.java))
        }
        binding.buttonRegister.setOnClickListener { // на клик кнопки
            val username = binding.editTextMail.text.toString() // ввод почты
            val password = binding.editTextPassword.text.toString() // ввод пароля

            if (username.isNotEmpty() && password.isNotEmpty()) { // если почта и пароль не пустые
                authApi.register(username, password, object : OnDataLoadedInterface {
                    override fun onSuccess(data: Any) {
                        startActivity(Intent(this@SignupForm, HolderActivity::class.java))
                        Toast.makeText(this@SignupForm, "Успешная регистрация", Toast.LENGTH_SHORT)
                            .show() // подобие popup

                    }

                    override fun onError(message: String) {
                        Toast.makeText(this@SignupForm, message, Toast.LENGTH_SHORT)
                            .show() // подобие popup

                    }

                }) // вызов функции регистрации
            } else {
                Toast.makeText(this, "Введите почту и пароль", Toast.LENGTH_SHORT)
                    .show() // подобие popup
            }
        }

        binding.textLogin.setOnClickListener {
            val intent = Intent(this, LoginForm::class.java)
            startActivity(intent)
        }
    }

}