package com.cristhian.apprecordar.data.model

import com.google.gson.annotations.SerializedName

data class DataResponse (
    @SerializedName("data") val data:UserModel?,
    @SerializedName("message") val message:String?,
    @SerializedName("status") val status:String?
)