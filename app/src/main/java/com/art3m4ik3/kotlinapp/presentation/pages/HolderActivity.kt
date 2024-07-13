package com.art3m4ik3.kotlinapp.presentation.pages

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.art3m4ik3.kotlinapp.databinding.ActivityHolderBinding

class HolderActivity : AppCompatActivity() {
    lateinit var binding: ActivityHolderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHolderBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}