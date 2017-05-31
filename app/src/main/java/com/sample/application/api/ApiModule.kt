package com.sample.application.api

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * Created by tomykho on 5/31/17.
 */

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideApi(): Api {
        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addCallAdapterFactory(ApiCallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        return retrofit.create(Api::class.java)
    }

}