package com.example.sensorapp.data.accelerometer

import com.example.sensorapp.domain.model.AccelerometerInfo
import com.example.sensorapp.domain.repository.AccelerometerRepository
import kotlinx.coroutines.flow.Flow

class AccelerometerRepositoryImpl(
    private val dataSource: AccelerometerDataSource
) : AccelerometerRepository {
    override fun observeAccelerometer(): Flow<AccelerometerInfo> =
        dataSource.observe()
}