package com.example.sensorapp.presentation.camera

import androidx.camera.core.ImageCapture
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.LocalLifecycleOwner

@Composable
fun CameraContent(
    viewModel: CameraViewModel,
    onBack: () -> Unit
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val uiState by viewModel.uiState.collectAsState()

    var imageCapture by remember {
        mutableStateOf<ImageCapture?>(null)
    }

    val cameraProviderFuture = remember {
        ProcessCameraProvider.getInstance(context)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        CameraPreview(
            cameraProviderFuture = cameraProviderFuture,
            lifecycleOwner = lifecycleOwner,
            onImageCaptureReady = { capture ->
                imageCapture = capture
                viewModel.setImageCapture(capture)
            }
        )

        Button(
            onClick = onBack,
            modifier = Modifier.align(Alignment.TopStart).padding(16.dp)
        ) {
            Text("← Volver")
        }

        Button(
            enabled = imageCapture != null && !uiState.isCapturing,
            onClick = { viewModel.takePhoto() },
            modifier = Modifier.align(Alignment.BottomCenter).padding(24.dp)
        ) {
            Text("📷 Tomar foto")
        }

        if (uiState.isCapturing) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }

        uiState.error?.let { error ->
            Text(
                text = error,
                modifier = Modifier.align(Alignment.Center).padding(32.dp)
            )
        }
    }
}