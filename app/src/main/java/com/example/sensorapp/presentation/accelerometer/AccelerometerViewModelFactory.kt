package com.example.sensorapp.presentation.accelerometer

import android.content.Context
import android.hardware.SensorManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sensorapp.data.accelerometer.AccelerometerDataSource
import com.example.sensorapp.data.accelerometer.AccelerometerRepositoryImpl
import com.example.sensorapp.domain.usecase.ObserveAccelerometerUseCase

class AccelerometerViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val sensorManager =
            context.getSystemService(Context.SENSOR_SERVICE) as SensorManager

        val dataSource = AccelerometerDataSource(sensorManager)
        val repository = AccelerometerRepositoryImpl(dataSource)
        val useCase = ObserveAccelerometerUseCase(repository)

        @Suppress("UNCHECKED_CAST")
        return AccelerometerViewModel(useCase) as T
    }
}