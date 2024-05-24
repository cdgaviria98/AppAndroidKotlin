package com.cristhian.apprecordar.data.network.services

import com.cristhian.apprecordar.core.RetrofitHelper
import com.cristhian.apprecordar.data.model.QuoteModel
import com.cristhian.apprecordar.data.network.clients.QuoteApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class QuoteService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes():List<QuoteModel>{
        return withContext(Dispatchers.IO){
            val response:Response<List<QuoteModel>> = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}