package com.example.sensorapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sensorapp.presentation.Sensor.SensorScreen
import com.example.sensorapp.presentation.Sensor.SensorViewModel
import com.example.sensorapp.presentation.Sensor.SensorViewModelFactory
import com.example.sensorapp.presentation.accelerometer.AccelerometerScreen
import com.example.sensorapp.presentation.accelerometer.AccelerometerViewModel
import com.example.sensorapp.presentation.accelerometer.AccelerometerViewModelFactory
import com.example.sensorapp.presentation.camera.CameraScreen
import com.example.sensorapp.presentation.camera.CameraViewModel
import com.example.sensorapp.presentation.camera.CameraViewModelFactory
import com.example.sensorapp.presentation.device.DeviceScreen
import com.example.sensorapp.presentation.device.DeviceViewModel
import com.example.sensorapp.presentation.device.DeviceViewModelFactory
import com.example.sensorapp.presentation.home.HomeScreen
import com.example.sensorapp.presentation.location.LocationScreen
import com.example.sensorapp.presentation.location.LocationViewModel
import com.example.sensorapp.presentation.location.LocationViewModelFactory

@Composable
fun AppNavigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = AppRoutes.HOME
    ) {
        composable(AppRoutes.HOME) {
            HomeScreen(
                onNavigate = { route ->
                    navController.navigate(route)
                }
            )
        }

        composable(AppRoutes.DEVICE) {
            val vm: DeviceViewModel = viewModel(
                factory = DeviceViewModelFactory()
            )
            DeviceScreen(viewModel = vm)
        }

        composable(AppRoutes.SENSORS) {
            val context = LocalContext.current.applicationContext
            val vm: SensorViewModel = viewModel(
                factory = SensorViewModelFactory(context)
            )
            SensorScreen(viewModel = vm)
        }

        composable(AppRoutes.GPS) {
            val context = LocalContext.current.applicationContext
            val vm: LocationViewModel = viewModel(
                factory = LocationViewModelFactory(context)
            )
            LocationScreen(
                viewModel = vm,
                onBack = { navController.popBackStack() }
            )
        }

        composable(AppRoutes.CAMERA) {
            val context = LocalContext.current.applicationContext
            val vm: CameraViewModel = viewModel(
                factory = CameraViewModelFactory(context)
            )
            CameraScreen(
                viewModel = vm,
                onBack = { navController.popBackStack() }
            )
        }

        composable(AppRoutes.ACCELEROMETER) {
            val context = LocalContext.current.applicationContext
            val vm: AccelerometerViewModel = viewModel(
                factory = AccelerometerViewModelFactory(context)
            )
            AccelerometerScreen(
                viewModel = vm,
                onBack = { navController.popBackStack() }
            )
        }
    }
}