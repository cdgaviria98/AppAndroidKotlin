package com.cristiang.calculadoraapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.cristiang.calculadoraapp.databinding.ActivityFuncionesBinding
import com.cristiang.calculadoraapp.databinding.ActivityMainBinding
import com.cristiang.calculadoraapp.model.QuoteViewModel

class FuncionesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFuncionesBinding
    private val quoteViewModel: QuoteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_funciones)
        binding = ActivityFuncionesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        quoteViewModel.quoteModel.observe(this, Observer {
            binding.tvQuote.text = it.quote
            binding.tvAuthor.text = it.author
        })
        binding.viewContainer.setOnClickListener { quoteViewModel.randomQuote() }
    }
}

