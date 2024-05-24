package com.cristhian.apprecordar.data.network.clients

import com.cristhian.apprecordar.data.dto.LoginDTO
import com.cristhian.apprecordar.data.model.DataResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApiClient {
    @POST("sign_in")
    suspend fun signIn(@Body loginDto: LoginDTO): Response<DataResponse>
}