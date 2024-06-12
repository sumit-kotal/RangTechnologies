package com.example.rangtech.repository

import com.example.rangtech.db.InspectionDao
import com.example.rangtech.models.Inspection
import com.example.rangtech.models.User
import com.example.rangtech.network.ApiService
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

class InspectionRepository @Inject constructor(
    private val apiService: ApiService,
    private val inspectionDao: InspectionDao
) {
    suspend fun register(user: User): Response<Unit> {
        return apiService.register(user)
    }

    suspend fun login(user: User): Response<Unit> {
        return apiService.login(user)
    }

    suspend fun startInspection(): Inspection? {
        val response = apiService.startInspection()
        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }

    suspend fun submitInspection(inspection: Inspection): Boolean {
        val response = apiService.submitInspection(inspection)
        return response.isSuccessful
    }
}