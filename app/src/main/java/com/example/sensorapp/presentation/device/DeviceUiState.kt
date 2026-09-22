package com.example.sensorapp.presentation.device

import com.example.sensorapp.domain.model.DeviceInfo

data class DeviceUiState(
    val deviceInfo: DeviceInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)