package com.example.sensorapp.presentation.camera

import android.net.Uri

data class CameraUiState(
    val photoUri: Uri? = null,
    val isCapturing: Boolean = false,
    val error: String? = null
)