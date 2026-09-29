package com.example.sensorapp.presentation.accelerometer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sensorapp.domain.usecase.ObserveAccelerometerUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class AccelerometerViewModel(
    private val observeAccelerometerUseCase: ObserveAccelerometerUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(AccelerometerUiState())
    val uiState: StateFlow<AccelerometerUiState> = _uiState.asStateFlow()

    init {
        observe()
    }

    private fun observe() {
        viewModelScope.launch {
            observeAccelerometerUseCase()
                .catch { error ->
                    _uiState.value = AccelerometerUiState(
                        error = error.message ?: "Error al leer el acelerómetro"
                    )
                }
                .collect { data ->
                    _uiState.value = AccelerometerUiState(
                        x = data.x,
                        y = data.y,
                        z = data.z
                    )
                }
        }
    }
}