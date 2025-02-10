package com.posite.statemanagementex

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class StateManagementApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}