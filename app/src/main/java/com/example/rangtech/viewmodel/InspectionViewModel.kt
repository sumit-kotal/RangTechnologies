package com.example.rangtech.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rangtech.models.Inspection
import com.example.rangtech.repository.InspectionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InspectionViewModel @Inject constructor(
    private val repository: InspectionRepository
) : ViewModel() {

    private val _inspectionList = MutableStateFlow<List<Inspection>>(emptyList())
    val inspectionList: StateFlow<List<Inspection>> = _inspectionList.asStateFlow()

    private val _inspection = MutableStateFlow<Inspection?>(null)
    val inspection: StateFlow<Inspection?> = _inspection.asStateFlow()

    fun startInspection() {
        viewModelScope.launch {
            try {
                val newInspection = repository.startInspection()
                newInspection?.let {
                    _inspection.value = it
                }
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

    fun submitInspection(inspection: Inspection) {
        viewModelScope.launch {
            try {
                val success = repository.submitInspection(inspection)
                if (success) {
                    // Handle success
                } else {
                    // Handle failure
                }
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}