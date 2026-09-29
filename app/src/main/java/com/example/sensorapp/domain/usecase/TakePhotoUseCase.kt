package com.example.sensorapp.domain.usecase

import android.net.Uri
import com.example.sensorapp.domain.repository.CameraRepository

class TakePhotoUseCase(
    private val repository: CameraRepository
) {
    suspend operator fun invoke(): Uri? = repository.takePhoto()
}