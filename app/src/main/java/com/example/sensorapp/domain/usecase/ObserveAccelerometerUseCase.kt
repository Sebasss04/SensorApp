package com.example.sensorapp.domain.usecase

import com.example.sensorapp.domain.model.AccelerometerInfo
import com.example.sensorapp.domain.repository.AccelerometerRepository
import kotlinx.coroutines.flow.Flow

class ObserveAccelerometerUseCase(
    private val repository: AccelerometerRepository
) {
    operator fun invoke(): Flow<AccelerometerInfo> =
        repository.observeAccelerometer()
}