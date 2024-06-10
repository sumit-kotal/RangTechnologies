package com.example.rangtech.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rangtech.models.Inspection
import com.example.rangtech.repository.InspectionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InspectionDetailViewModel @Inject constructor(
    private val repository: InspectionRepository
) : ViewModel() {

    private val _inspection = MutableLiveData<Inspection>()
    val inspection: LiveData<Inspection> get() = _inspection

    fun loadInspection(id: Int) {
        viewModelScope.launch {
            val response = repository.getInspection(id)
            if (response.isSuccessful) {
                _inspection.postValue(response.body())
            }
        }
    }

    fun submitInspection() {
        viewModelScope.launch {
            // Collect and submit the inspection data
            val inspection = _inspection.value
            if (inspection != null) {
                repository.submitInspection(inspection)
            }
        }
    }
}