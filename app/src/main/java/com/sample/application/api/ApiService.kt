package com.sample.application.api

import com.sample.application.model.Album
import com.sample.application.model.Photo
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("albums")
    fun findAlbums(): Observable<List<Album>>

    @GET("albums/{albumId}/photos")
    fun findAlbumPhotos(@Path("albumId") albumId: Int): Observable<List<Photo>>

}