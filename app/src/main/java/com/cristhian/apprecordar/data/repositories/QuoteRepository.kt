package com.cristhian.apprecordar.data.repositories

import com.cristhian.apprecordar.data.model.QuoteModel
import com.cristhian.apprecordar.data.model.QuoteProvider
import com.cristhian.apprecordar.data.network.services.QuoteService

class QuoteRepository {
    private val api = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{
        val response:List<QuoteModel> = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}