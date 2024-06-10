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
class InspectionListViewModel @Inject constructor(
    private val repository: InspectionRepository
) : ViewModel() {

    private val _inspections = MutableLiveData<List<Inspection>>()
    val inspections: LiveData<List<Inspection>> get() = _inspections

    fun loadInspections() {
        viewModelScope.launch {
            val response = repository.getInspections()
            if (response.isSuccessful) {
                _inspections.postValue(response.body())
            }
        }
    }
}