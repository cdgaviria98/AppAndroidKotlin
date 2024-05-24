package com.cristhian.apprecordar.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cristhian.apprecordar.data.dto.LoginDTO
import com.cristhian.apprecordar.data.model.DataResponse
import com.cristhian.apprecordar.data.model.UserModel
import com.cristhian.apprecordar.domain.PostSignInUseCase
import kotlinx.coroutines.launch

class LoginViewModel:ViewModel() {
    val dataResponse = MutableLiveData<DataResponse>()
    val userModel = MutableLiveData<UserModel>()
    val message = MutableLiveData<String?>()
    val isLoading = MutableLiveData<Boolean>()

    var loginUseCase = PostSignInUseCase()

    fun signIn(loginDTO: LoginDTO){
        viewModelScope.launch {
            isLoading.postValue(true)

            val result:DataResponse = loginUseCase(loginDTO)
            dataResponse.postValue(result)

            when(result.status){
                "success" -> {
                    userModel.postValue(result.data!!)
                    Log.e("Model User", userModel.toString())
                    isLoading.postValue(false)

                }
                "invalid" -> {
                    message.postValue(result.message)
                    isLoading.postValue(false)
                }
                "error" -> {
                    message.postValue("Username no registrado! \uD83D\uDE14")
                    isLoading.postValue(false)
                }
            }

        }
    }

}