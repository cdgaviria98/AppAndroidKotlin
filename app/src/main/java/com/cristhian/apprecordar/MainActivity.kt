package com.cristhian.apprecordar

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cristhian.apprecordar.databinding.ActivityMainBinding

// Inicializar los componentes de la vista
private lateinit var tvUno:TextView
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Enlazar componentes con la vista por Id
        tvUno = findViewById(R.id.tvUno)

        tvUno.setText("Hola")
        tvUno.text = "Hola cracks!"

        // Sum dos number
        var resultado:Int = 0
        resultado = sumar(2,5)

        val resultadoVal:Int = sumar(2,5)
        tvUno.text = "El resultado de la suma es $resultado"

    }

    private fun sumar(numUno: Int, numDos:Int):Int{
        return numUno + numDos
    }
}