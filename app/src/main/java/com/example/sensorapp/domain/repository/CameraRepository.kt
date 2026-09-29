package com.example.sensorapp.domain.repository

import android.net.Uri

interface CameraRepository {
    suspend fun takePhoto(): Uri?
}