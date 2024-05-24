package com.cristhian.apprecordar.domain

import com.cristhian.apprecordar.data.dto.LoginDTO
import com.cristhian.apprecordar.data.model.DataResponse
import com.cristhian.apprecordar.data.repositories.LoginRepository

class PostSignInUseCase {
    private val repository = LoginRepository()

    suspend operator fun invoke(loginDTO: LoginDTO):DataResponse{
        return repository.signIn(loginDTO)
    }
}