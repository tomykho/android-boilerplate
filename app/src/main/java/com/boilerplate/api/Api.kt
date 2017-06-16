package com.boilerplate.api

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

object Api {

    val service: ApiService by lazy {
        val objectMapper = ObjectMapper()
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addCallAdapterFactory(ApiCallAdapter.Factory.create())
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .build()
        retrofit.create(ApiService::class.java)
    }

}