package com.example.sensorapp.domain.usecase

import com.example.sensorapp.domain.model.DeviceInfo
import com.example.sensorapp.domain.repository.DeviceRepository

class GetDeviceInfoUseCase(
    private val repository: DeviceRepository
) {
    operator fun invoke(): DeviceInfo {
        return repository.getDeviceInfo()
    }
}