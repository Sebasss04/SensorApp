package com.example.sensorapp.data.location

import com.example.sensorapp.domain.model.LocationInfo
import com.example.sensorapp.domain.repository.LocationRepository

class LocationRepositoryImpl(
    private val dataSource: LocationDataSource
) : LocationRepository {
    override suspend fun getCurrentLocation(): LocationInfo? =
        dataSource.getCurrentLocation()
}