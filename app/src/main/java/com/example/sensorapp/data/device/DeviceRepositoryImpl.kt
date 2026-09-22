package com.example.sensorapp.data.device

import com.example.sensorapp.domain.model.DeviceInfo
import com.example.sensorapp.domain.repository.DeviceRepository

class DeviceRepositoryImpl (
    private val dataSource: DeviceDataSource
) : DeviceRepository {
    override fun getDeviceInfo(): DeviceInfo{
        return dataSource.getDeviceInf()
    }
}