package com.example.sensorapp.presentation.accelerometer

data class AccelerometerUiState(
    val x: Float = 0f,
    val y: Float = 0f,
    val z: Float = 0f,
    val error: String? = null
)