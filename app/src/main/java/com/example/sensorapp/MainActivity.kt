package com.example.sensorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.example.sensorapp.presentation.device.DeviceScreen
import com.example.sensorapp.presentation.device.DeviceViewModel
import com.example.sensorapp.presentation.device.DeviceViewModelFactory
import com.example.sensorapp.ui.theme.SensorAppTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sensorapp.presentation.Sensor.SensorScreen
import com.example.sensorapp.presentation.Sensor.SensorViewModel
import com.example.sensorapp.presentation.Sensor.SensorViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SensorAppTheme {
                MaterialTheme{
                    /*val viewModel: DeviceViewModel = viewModel(
                        factory = DeviceViewModelFactory()
                    )*/
                    val sensorViewModel: SensorViewModel = viewModel(factory = SensorViewModelFactory( applicationContext ))
                    SensorScreen(viewModel = sensorViewModel)
                SensorScreen(
                    viewModel = viewModel()
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SensorAppTheme {
        Greeting("Android")
    }
}