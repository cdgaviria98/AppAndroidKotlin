package com.example.mvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.data.model.QuoteModel
import com.example.mvvm.data.model.QuoteProvider
import com.example.mvvm.domain.GetQuotesUseCase
import com.example.mvvm.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel:ViewModel() {
    val quoteModel = MutableLiveData<QuoteModel>()

    //para mostrar el loading
    val isLoading = MutableLiveData<Boolean>()

    //use cases
    var getQuotesUseCase = GetQuotesUseCase()

    var getRamdomQuoteUseCase = GetRandomQuoteUseCase()
    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result:List<QuoteModel>? = getQuotesUseCase()

            if (!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }



   fun randomQuote(){
       isLoading.postValue(true)
       val quote = getRamdomQuoteUseCase()
       if (quote != null){
           quoteModel.postValue(quote)
       }
       isLoading.postValue(false)
    }

}