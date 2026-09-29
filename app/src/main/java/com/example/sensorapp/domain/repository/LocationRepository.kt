package com.example.sensorapp.domain.repository

import com.example.sensorapp.domain.model.LocationInfo

interface LocationRepository {
    suspend fun getCurrentLocation(): LocationInfo?
}