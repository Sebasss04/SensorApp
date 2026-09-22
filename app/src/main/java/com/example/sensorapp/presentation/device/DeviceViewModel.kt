package com.example.sensorapp.presentation.device

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.example.sensorapp.domain.usecase.GetDeviceInfoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DeviceViewModel (
    private val getDeviceInfoUseCase: GetDeviceInfoUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(DeviceUiState())
    val uiState: StateFlow<DeviceUiState> = _uiState.asStateFlow()

    init {
        loadDeviceInfo()
    }

    fun loadDeviceInfo() {
        _uiState.update { it.copy(isLoading = true, error = null) }

        try {
            val deviceInfo = getDeviceInfoUseCase()
            _uiState.update {
                it.copy(deviceInfo = deviceInfo, isLoading = false)
            }
        } catch (e: Exception) {
            _uiState.update {
                it.copy(isLoading = false, error = e.message)
            }
        }
    }
}