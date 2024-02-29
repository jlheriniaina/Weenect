package com.weenect.testweenect

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WeenectApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}