package com.example.sensorapp.presentation.Sensor

import android.content.ClipData
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.foundation.lazy.items

@Composable
fun SensorScreen( viewModel: SensorViewModel ) {

    val uiState by viewModel.uiState.collectAsState()

    when { uiState.isLoading -> {
        CircularProgressIndicator()
    } uiState.error != null -> {
        Text(text = "Error: ${uiState.error}")
    }

        else -> {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement =
                    Arrangement.spacedBy(8.dp)
            ) {

                item {

                    Text(
                        text = "📡 Sensores disponibles",
                        style =
                            MaterialTheme.typography
                                .headlineSmall
                    )
                }

                items(uiState.sensors) { sensor ->
                    SensorItem(sensor)
                }
            }
        }
    }
}