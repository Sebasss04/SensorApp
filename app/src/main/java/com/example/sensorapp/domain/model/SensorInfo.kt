package com.example.sensorapp.domain.model

data class SensorInfo(
    val name: String,
    val type: Int,
    val vendor: String,
    val version: Int
)