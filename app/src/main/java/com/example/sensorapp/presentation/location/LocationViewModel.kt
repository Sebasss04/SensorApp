package com.example.sensorapp.presentation.location

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sensorapp.domain.usecase.GetCurrentLocationUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LocationViewModel(
    private val getCurrentLocationUseCase: GetCurrentLocationUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(LocationUiState())
    val uiState: StateFlow<LocationUiState> = _uiState.asStateFlow()

    fun getLocation() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }

            try {
                val location = getCurrentLocationUseCase()
                if (location != null) {
                    _uiState.update { it.copy(location = location, isLoading = false) }
                } else {
                    _uiState.update {
                        it.copy(isLoading = false, error = "No se pudo obtener la ubicación")
                    }
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(isLoading = false, error = e.message ?: "Error desconocido")
                }
            }
        }
    }
}