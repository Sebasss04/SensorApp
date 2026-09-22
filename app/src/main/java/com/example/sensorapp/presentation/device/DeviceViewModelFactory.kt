package com.example.sensorapp.presentation.device

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sensorapp.data.device.DeviceDataSource
import com.example.sensorapp.data.device.DeviceRepositoryImpl
import com.example.sensorapp.domain.usecase.GetDeviceInfoUseCase

class DeviceViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>):T{
        val dataSource = DeviceDataSource()
        val repository = DeviceRepositoryImpl(dataSource)
        val useCase = GetDeviceInfoUseCase(repository)
        return DeviceViewModel(useCase)as T
    }
}