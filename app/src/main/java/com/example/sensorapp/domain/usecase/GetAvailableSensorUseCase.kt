package com.example.sensorapp.domain.usecase

import com.example.sensorapp.domain.model.SensorInfo
import com.example.sensorapp.domain.repository.SensorRepository

class GetAvailableSensorUseCase(private val repository: SensorRepository) {
    operator fun invoke(): List<SensorInfo>{
        return repository.getAvailableSensors()
    }
}