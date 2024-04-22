package com.example.april21retrofit.api


import com.example.april21retrofit.model.Photos
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("photos")
    suspend fun getPhotos(): Response<Photos>
}