package com.cristiang.calculadoraapp.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class QuoteModel(val quote:String, val author:String)

class QuoteViewModel : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()

    fun randomQuote() {
        val currentQuote = QuoteProvider.random()
        quoteModel.postValue(currentQuote)
    }
}
