package com.example.sensorapp.domain.model

data class DeviceInfo (
    val manufacturer: String,
    val brand: String,
    val model: String,
    val androidVersion: String,
    val sdkVersion: Int
)