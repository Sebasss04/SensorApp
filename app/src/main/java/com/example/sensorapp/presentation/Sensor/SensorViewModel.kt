package com.example.sensorapp.presentation.Sensor

import androidx.lifecycle.ViewModel
import com.example.sensorapp.domain.model.SensorInfo
import com.example.sensorapp.domain.usecase.GetAvailableSensorUseCase
import com.example.sensorapp.presentation.device.DeviceUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SensorViewModel(private val getAvailableSensorUseCase: GetAvailableSensorUseCase): ViewModel() {
    private val _uiState = MutableStateFlow(value = SensorUiState())

    val uiState: StateFlow<SensorUiState> = _uiState.asStateFlow()

    init {
        loadSensorInfo()
    }

    fun loadSensorInfo() {
        _uiState.update { it.copy(isLoading = true, error = null) }

        try {
            val sensors = getAvailableSensorUseCase()
            _uiState.update {
                it.copy(sensors = sensors, isLoading = false)
            }
        } catch (e: Exception) {
            _uiState.update {
                it.copy(isLoading = false, error = e.message)
            }
        }
    }
}