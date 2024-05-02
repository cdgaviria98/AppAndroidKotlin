package com.cristiang.calculadoraapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cristiang.calculadoraapp.databinding.ActivityFuncionesBinding

class FuncionesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFuncionesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityFuncionesBinding.inflate(layoutInflater)

        setContentView(binding.root)

    }
}