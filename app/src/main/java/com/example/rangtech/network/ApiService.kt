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
    suspend fun register(@Body user: User): Response<Void>

    @POST("api/login")
    suspend fun login(@Body user: User): Response<Void>

    @GET("api/inspections")
    suspend fun getInspections(): Response<List<Inspection>>

    @GET("api/inspections/{id}")
    suspend fun getInspection(@Path("id") id: Int): Response<Inspection>

    @POST("api/inspections/submit")
    suspend fun submitInspection(@Body inspection: Inspection): Response<Void>
}