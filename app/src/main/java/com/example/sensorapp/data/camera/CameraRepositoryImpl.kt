package com.example.sensorapp.data.camera

import android.net.Uri
import com.example.sensorapp.domain.repository.CameraRepository
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class CameraRepositoryImpl(
    private val dataSource: CameraDataSource
) : CameraRepository {

    override suspend fun takePhoto(): Uri? =
        suspendCancellableCoroutine { continuation ->
            dataSource.takePhoto(
                onSuccess = { uri -> continuation.resume(uri) },
                onError = { error -> continuation.resumeWithException(error) }
            )
        }
}