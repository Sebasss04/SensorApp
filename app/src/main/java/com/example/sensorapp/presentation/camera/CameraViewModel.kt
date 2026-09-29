package com.example.sensorapp.presentation.camera

import androidx.camera.core.ImageCapture
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sensorapp.data.camera.CameraDataSource
import com.example.sensorapp.domain.usecase.TakePhotoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CameraViewModel(
    private val takePhotoUseCase: TakePhotoUseCase,
    private val cameraDataSource: CameraDataSource
) : ViewModel() {

    private val _uiState = MutableStateFlow(CameraUiState())
    val uiState: StateFlow<CameraUiState> = _uiState.asStateFlow()

    fun setImageCapture(imageCapture: ImageCapture) {
        cameraDataSource.setImageCapture(imageCapture)
    }

    fun takePhoto() {
        viewModelScope.launch {
            _uiState.update { it.copy(isCapturing = true, error = null) }

            try {
                val uri = takePhotoUseCase()
                _uiState.update {
                    it.copy(photoUri = uri, isCapturing = false)
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isCapturing = false,
                        error = e.message ?: "No se pudo tomar la fotografía"
                    )
                }
            }
        }
    }
}