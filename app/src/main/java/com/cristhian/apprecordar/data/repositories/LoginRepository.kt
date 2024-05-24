package com.cristhian.apprecordar.data.repositories

import com.cristhian.apprecordar.data.dto.LoginDTO
import com.cristhian.apprecordar.data.model.DataResponse
import com.cristhian.apprecordar.data.network.services.LoginService
import com.cristhian.apprecordar.data.providers.UserProvider

class LoginRepository {
    val loginService = LoginService()

    suspend fun signIn(loginDTO: LoginDTO):DataResponse{
        val response: DataResponse = loginService.signIn(loginDTO)
        if(response.status == "success"){
            if (response.data != null){
                UserProvider.userModel = response.data
            }
        }
        return response
    }
}