package com.example.sensorapp.presentation.location

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sensorapp.domain.model.LocationInfo

@Composable
fun LocationCard(location: LocationInfo) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text("📍 Ubicación actual", style = MaterialTheme.typography.titleLarge)
            Text("Latitud: %.6f".format(location.latitude))
            Text("Longitud: %.6f".format(location.longitude))
            Text("Precisión: %.2f metros".format(location.accuracy))
        }
    }
}