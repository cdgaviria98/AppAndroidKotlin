package com.cristiang.calculadoraapp.view

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cristiang.calculadoraapp.R
import com.cristiang.calculadoraapp.model.QuoteViewModel

class MainActivity : AppCompatActivity() {

    //declaramos variables
    private lateinit var tvResult: TextView
    private lateinit var tvNum1: TextView
    private lateinit var tvNum2: TextView
    private var operand1: Double = 0.0
    private var operand2: Double = 0.0
    private var operator: String = ""
    private var numbersList = mutableListOf<Double>()
    private var currentInput = StringBuilder() // Guarda la entrada actual

    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvNum1 = findViewById(R.id.tv_num1)
        tvResult = findViewById(R.id.tv_num1)

        // Set click listeners for number buttons
        val numberButtons = listOf<Button>(
            findViewById(R.id.btn0), findViewById(R.id.btn1), findViewById(R.id.btn2),
            findViewById(R.id.btn3), findViewById(R.id.btn4), findViewById(R.id.btn5),
            findViewById(R.id.btn6), findViewById(R.id.btn7), findViewById(R.id.btn8),
            findViewById(R.id.btn9)
        )
        numberButtons.forEach { button ->
            button.setOnClickListener { appendNumber(button.text.toString()) }
        }

        // Set click listeners for operator buttons
        val operatorButtons = listOf<Button>(
            findViewById(R.id.btnSumar), findViewById(R.id.btnRestar),
            findViewById(R.id.btnMult), findViewById(R.id.btnDividir)
        )
        operatorButtons.forEach { button ->
            button.setOnClickListener { setOperator(button.text.toString()) }
        }

        // Set click listener for equals button
        findViewById<Button>(R.id.btnIgual).setOnClickListener { calculate() }

        // Set click listener for clear button
        findViewById<Button>(R.id.btnBorrar).setOnClickListener { clear() }
    }

    private fun appendNumber(number: String) {
        currentInput.append(number)
        tvResult.text = currentInput.toString()
    }

    private fun setOperator(op: String) {
        if (currentInput.isNotEmpty()) {
            numbersList.add(currentInput.toString().toDouble())
            currentInput.clear()
            operator = op
        }
    }

    private fun calculate() {
        if (currentInput.isNotEmpty()) {
            numbersList.add(currentInput.toString().toDouble())
            var result = numbersList[0]

            //oepraciones
            for (i in 1 until numbersList.size) {
                when (operator) {
                    "+" -> result += numbersList[i]
                    "-" -> result -= numbersList[i]
                    "*" -> result *= numbersList[i]
                    "/" -> {
                        //division por cero
                        if (numbersList[i] == 0.0) {
                            tvResult.text = "No se puede dividir por cero"
                            currentInput.clear()
                            numbersList.clear()
                            return
                        } else {
                            result /= numbersList[i]
                        }
                    }
                }
            }

            tvResult.text = result.toString()
            currentInput.clear()
            numbersList.clear()
        }
    }

    private fun clear() {
        numbersList.clear()
        currentInput.clear()
        tvResult.text = "0"
    }
}
