package com.example.sensorapp.data.location

import android.annotation.SuppressLint
import com.example.sensorapp.domain.model.LocationInfo
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.Priority
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class LocationDataSource(
    private val fusedLocationClient: FusedLocationProviderClient
) {
    @SuppressLint("MissingPermission")
    suspend fun getCurrentLocation(): LocationInfo? =
        suspendCancellableCoroutine { continuation ->
            fusedLocationClient
                .getCurrentLocation(Priority.PRIORITY_HIGH_ACCURACY, null)
                .addOnSuccessListener { location ->
                    continuation.resume(
                        location?.let {
                            LocationInfo(
                                latitude = it.latitude,
                                longitude = it.longitude,
                                accuracy = it.accuracy
                            )
                        }
                    )
                }
                .addOnFailureListener {
                    continuation.resume(null)
                }
        }
}