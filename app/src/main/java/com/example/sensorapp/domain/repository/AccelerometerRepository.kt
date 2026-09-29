package com.example.sensorapp.domain.repository

import com.example.sensorapp.domain.model.AccelerometerInfo
import kotlinx.coroutines.flow.Flow

interface AccelerometerRepository {
    fun observeAccelerometer(): Flow<AccelerometerInfo>
}