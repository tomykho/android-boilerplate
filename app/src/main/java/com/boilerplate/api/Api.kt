package com.boilerplate.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api {

    val service: ApiService by lazy {
        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addCallAdapterFactory(ApiCallAdapter.Factory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        retrofit.create(ApiService::class.java)
    }

}