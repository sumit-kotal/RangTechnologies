package com.example.rangtech.repository

import com.example.rangtech.models.Inspection
import com.example.rangtech.models.User
import com.example.rangtech.network.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InspectionRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun register(user: User) = apiService.register(user)

    suspend fun login(user: User) = apiService.login(user)

    suspend fun getInspections() = apiService.getInspections()

    suspend fun getInspection(id: Int) = apiService.getInspection(id)

    suspend fun submitInspection(inspection: Inspection) = apiService.submitInspection(inspection)
}