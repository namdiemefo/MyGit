package com.example.core_profiles.data

import ProfilesResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProfileApiService {

    @GET("users/")
    suspend fun getAllProfiles(@Query("q") query: String, @Query("page") page: Int): Response<ProfilesResponseModel>

}