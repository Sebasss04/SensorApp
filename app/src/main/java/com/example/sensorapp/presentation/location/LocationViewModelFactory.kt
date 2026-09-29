package com.example.sensorapp.presentation.location

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sensorapp.data.location.LocationDataSource
import com.example.sensorapp.data.location.LocationRepositoryImpl
import com.example.sensorapp.domain.usecase.GetCurrentLocationUseCase
import com.google.android.gms.location.LocationServices

class LocationViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val client = LocationServices.getFusedLocationProviderClient(context)
        val dataSource = LocationDataSource(client)
        val repository = LocationRepositoryImpl(dataSource)
        val useCase = GetCurrentLocationUseCase(repository)

        @Suppress("UNCHECKED_CAST")
        return LocationViewModel(useCase) as T
    }
}