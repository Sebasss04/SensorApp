package com.example.sensorapp.data.device

import android.os.Build
import com.example.sensorapp.domain.model.DeviceInfo

class DeviceDataSource {
    fun getDeviceInfo(): DeviceInfo {
        return DeviceInfo(
            manufacturer = Build.MANUFACTURER,
            brand = Build.BRAND,
            model = Build.MODEL,
            androidVersion = Build.VERSION.RELEASE,
            sdkVersion = Build.VERSION.SDK_INT
        )
    }
}