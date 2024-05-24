package com.cristhian.apprecordar.ui.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.cristhian.apprecordar.data.utils.SharedApp
import com.cristhian.apprecordar.databinding.ActivityFrasesBinding
import com.cristhian.apprecordar.ui.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FrasesActivity : AppCompatActivity() {
    private lateinit var binding:ActivityFrasesBinding

    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFrasesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this, Observer {
            binding.tvQuote.text  = it?.quote
            binding.tvAuthor.text = it?.author
        })

        quoteViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })

        binding.viewContainer.setOnClickListener{ quoteViewModel.randomQuote() }

        val nombre = SharedApp.prefs.name

        binding.tvNameAuth.text = nombre
    }
}