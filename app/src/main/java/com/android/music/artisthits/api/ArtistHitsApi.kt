package com.android.music.artisthits.api

import com.android.music.artisthits.models.AlbumsListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface ArtistHitsApi{
    @GET("/v3/b/65d4b8d3266cfc3fde8cd6f9?meta=false")
    suspend fun getHits(@Header("X-JSON-Path") singer : String) : Response<List<AlbumsListItem>>

    @GET("/v3/b/65d4c84a266cfc3fde8cdd32?meta=false")
    @Headers("X-JSON-Path")
    suspend fun getSingers() : Response<List<String>>
}