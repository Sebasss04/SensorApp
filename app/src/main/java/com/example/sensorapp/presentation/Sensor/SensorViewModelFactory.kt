package com.example.sensorapp.presentation.Sensor

import android.content.Context
import android.hardware.SensorPrivacyManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sensorapp.data.Sensor.SensorDataSource
import android.hardware.SensorManager
import com.example.sensorapp.data.Sensor.SensorRepositoryImpl
import com.example.sensorapp.domain.repository.SensorRepository
import com.example.sensorapp.domain.usecase.GetAvailableSensorUseCase

class SensorViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        val sensorManager =
            context.getSystemService(Context.SENSOR_SERVICE) as SensorManager

        val dataSource = SensorDataSource(sensorManager)

        val repository = SensorRepositoryImpl(dataSource)

        val useCase = GetAvailableSensorUseCase(repository)

        return SensorViewModel(
            useCase) as T
    }
}