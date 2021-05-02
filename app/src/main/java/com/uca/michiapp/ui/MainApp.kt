package com.uca.michiapp.ui

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MainApp : Application(){

    override fun onCreate() {
        super.onCreate()
    }
}