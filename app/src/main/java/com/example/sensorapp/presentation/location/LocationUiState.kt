package com.example.sensorapp.presentation.location

import com.example.sensorapp.domain.model.LocationInfo

data class LocationUiState(
    val location: LocationInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)