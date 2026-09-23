package com.example.sensorapp.data.Sensor

import android.hardware.Sensor
import android.hardware.SensorManager
import com.example.sensorapp.domain.model.SensorInfo

class SensorDataSource(
    private val sensorManager: SensorManager
) {
    fun getAvailableSensors(): List<SensorInfo> {
        return sensorManager
            .getSensorList(Sensor.TYPE_ALL)
            .map { sensor ->
                SensorInfo(
                    name = sensor.name,
                    type = sensor.type,
                    vendor = sensor.vendor,
                    version = sensor.version
                )
            }
    }
}