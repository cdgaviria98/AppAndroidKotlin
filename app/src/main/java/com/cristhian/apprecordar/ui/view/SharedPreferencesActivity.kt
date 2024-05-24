package com.cristhian.apprecordar.ui.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.cristhian.apprecordar.data.utils.SharedApp
import com.cristhian.apprecordar.databinding.ActivitySharedPreferencesBinding

class SharedPreferencesActivity : AppCompatActivity() {
    lateinit var binding: ActivitySharedPreferencesBinding
    val EMPTY_VALUE = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySharedPreferencesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configView()

        binding.btnSaveValue.setOnClickListener {
            SharedApp.prefs.name = binding.etName.text.toString()
            configView()
        }

        binding.btnDeleteValue.setOnClickListener {
            SharedApp.prefs.name = EMPTY_VALUE
            configView()
        }

    }
    fun showProfile(){
        binding.tvName.isVisible = true
        binding.tvName.text = "Hola ${SharedApp.prefs.name}"
        binding.btnDeleteValue.isVisible = true
        binding.etName.isVisible = false
        binding.btnSaveValue.isVisible = false
    }

    fun showGuest(){
        binding.tvName.isVisible = false
        binding.btnDeleteValue.isVisible = false
        binding.etName.isVisible = true
        binding.btnSaveValue.isVisible = true
    }

    fun configView(){
        if(isSavedName()) showProfile() else showGuest()
    }

    fun isSavedName():Boolean{
        val myName = SharedApp.prefs.name
        return myName != EMPTY_VALUE
    }
}

