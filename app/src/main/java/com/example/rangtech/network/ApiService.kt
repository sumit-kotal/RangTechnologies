package com.example.rangtech.network

import com.example.rangtech.models.Inspection
import com.example.rangtech.models.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("api/register")
    suspend fun register(@Body user: User): Response<Unit>

    @POST("api/login")
    suspend fun login(@Body user: User): Response<Unit>

    @GET("api/inspections/start")
    suspend fun startInspection(): Response<Inspection>

    @POST("api/inspections/submit")
    suspend fun submitInspection(@Body inspection: Inspection): Response<Unit>
}