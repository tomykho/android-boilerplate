package com.sample.application.api

import com.sample.application.model.Album
import io.reactivex.Observable
import retrofit2.http.GET

interface Api {
    @GET("albums")
    fun findAlbums(): Observable<List<Album>>
}