package com.cristhian.apprecordar.core.di

import com.cristhian.apprecordar.core.RetrofitHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) //activity - persiste durante toda la vida de la app

object NetworkModule {
    private const val BASE_URL = "https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/"

    //proveer retrofit
    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}