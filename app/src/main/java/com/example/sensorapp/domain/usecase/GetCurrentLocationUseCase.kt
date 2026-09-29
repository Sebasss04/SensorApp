package com.example.sensorapp.domain.usecase

import com.example.sensorapp.domain.model.LocationInfo
import com.example.sensorapp.domain.repository.LocationRepository

class GetCurrentLocationUseCase(
    private val repository: LocationRepository
) {
    suspend operator fun invoke(): LocationInfo? = repository.getCurrentLocation()
}