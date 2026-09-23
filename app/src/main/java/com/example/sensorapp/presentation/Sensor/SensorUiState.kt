package com.example.sensorapp.presentation.Sensor

import com.example.sensorapp.domain.model.SensorInfo

data class SensorUiState (
    val sensors: List<SensorInfo> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)