package com.cristhian.apprecordar.data.network.clients

import com.cristhian.apprecordar.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET(".json")
    suspend fun getAllQuotes():Response<List<QuoteModel>>

}