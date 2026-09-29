package com.example.sensorapp.presentation.camera

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sensorapp.data.camera.CameraDataSource
import com.example.sensorapp.data.camera.CameraRepositoryImpl
import com.example.sensorapp.domain.usecase.TakePhotoUseCase

class CameraViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val dataSource = CameraDataSource(context)
        val repository = CameraRepositoryImpl(dataSource)
        val useCase = TakePhotoUseCase(repository)

        @Suppress("UNCHECKED_CAST")
        return CameraViewModel(useCase, dataSource) as T
    }
}