package com.example.sensorapp.domain.repository

import android.hardware.Sensor
import com.example.sensorapp.domain.model.SensorInfo

interface SensorRepository{
    fun getAvailableSensors(): List<SensorInfo>
}