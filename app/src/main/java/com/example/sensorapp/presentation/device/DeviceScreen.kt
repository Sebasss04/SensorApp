package com.example.sensorapp.presentation.device

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DeviceScreen(viewModel: DeviceViewModel) {

    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "📱 Mi Dispositivo",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        if (uiState.isLoading) {

            CircularProgressIndicator()

        } else if (uiState.error != null) {

            Text(
                text = "Error: ${uiState.error}"
            )

        } else {

            uiState.deviceInfo?.let { device ->

                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {

                        Text(
                            text = "Información del dispositivo",
                            style = MaterialTheme.typography.titleLarge
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text("Fabricante: ${device.manufacturer}")
                        Text("Marca: ${device.brand}")
                        Text("Modelo: ${device.model}")
                        Text("Android: ${device.androidVersion}")
                        Text("SDK: ${device.sdkVersion}")
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                viewModel.loadDeviceInfo()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Actualizar")
        }
    }
}