package com.sample.application.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Api {

    val service: ApiService

    init {
        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addCallAdapterFactory(ApiCallAdapter.Factory.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        service = retrofit.create(ApiService::class.java)
    }

}