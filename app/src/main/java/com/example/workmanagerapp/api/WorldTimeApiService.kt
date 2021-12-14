package com.example.workmanagerapp.api

import retrofit2.Response
import retrofit2.http.GET

interface WorldTimeApiService {

    @GET("api/timezone/Asia/Taipei")
    suspend fun fetchWorldTime(): Response<WorldTimeResponse>

}