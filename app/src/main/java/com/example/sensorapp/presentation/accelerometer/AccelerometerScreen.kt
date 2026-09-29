package com.example.sensorapp.presentation.accelerometer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AccelerometerScreen(
    viewModel: AccelerometerViewModel,
    onBack: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "📐 Acelerómetro",
            style = MaterialTheme.typography.headlineMedium
        )

        Button(onClick = onBack) {
            Text("← Volver")
        }

        uiState.error?.let {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error
            )
        } ?: run {
            Text("Eje X: %.2f m/s²".format(uiState.x))
            Text("Eje Y: %.2f m/s²".format(uiState.y))
            Text("Eje Z: %.2f m/s²".format(uiState.z))

            Text(
                text = "Mové o incliná el teléfono y los valores cambiarán en tiempo real.",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}