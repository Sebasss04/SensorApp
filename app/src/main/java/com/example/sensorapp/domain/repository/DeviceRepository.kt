package com.example.sensorapp.domain.repository

import com.example.sensorapp.domain.model.DeviceInfo

interface DeviceRepository {
    fun getDeviceInfo(): DeviceInfo
}