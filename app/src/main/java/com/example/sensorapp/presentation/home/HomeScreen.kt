package com.example.sensorapp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.sensorapp.presentation.navigation.AppRoutes

data class DeviceCapability(
    val icon: String,
    val title: String,
    val description: String,
    val route: String
)

private val capabilities = listOf(
    DeviceCapability("📱", "Información", "Conoce tu dispositivo", AppRoutes.DEVICE),
    DeviceCapability("📡", "Sensores", "Explora sus sensores", AppRoutes.SENSORS),
    DeviceCapability("📍", "GPS", "Obtén tu ubicación", AppRoutes.GPS),
    DeviceCapability("📷", "Cámara", "Captura fotografías", AppRoutes.CAMERA),
    DeviceCapability("📐", "Acelerómetro", "Detecta movimiento", AppRoutes.ACCELEROMETER)
)

@Composable
fun HomeScreen(onNavigate: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 20.dp)
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "📱 Mi Dispositivo",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Explora las capacidades de tu dispositivo Android",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(24.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(capabilities) { capability ->
                CapabilityCard(
                    capability = capability,
                    onClick = { onNavigate(capability.route) }
                )
            }
        }
    }
}