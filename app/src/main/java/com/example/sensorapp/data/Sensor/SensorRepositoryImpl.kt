package com.example.sensorapp.data.Sensor

import com.example.sensorapp.domain.model.SensorInfo
import com.example.sensorapp.domain.repository.SensorRepository

class SensorRepositoryImpl(private val dataSource: SensorDataSource): SensorRepository
{
    override fun getAvailableSensors(): List<SensorInfo> {
        return dataSource.getAvailableSensors()
    }
}