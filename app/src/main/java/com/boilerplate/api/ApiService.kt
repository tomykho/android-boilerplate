package com.boilerplate.api

import com.boilerplate.model.Album
import com.boilerplate.model.Photo
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("albums")
    fun findAlbums(): Observable<List<Album>>

    @GET("albums/{albumId}/photos")
    fun findAlbumPhotos(@Path("albumId") albumId: Int): Observable<List<Photo>>

}