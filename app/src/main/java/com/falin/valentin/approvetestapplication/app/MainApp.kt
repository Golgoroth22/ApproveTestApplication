package com.falin.valentin.approvetestapplication.app

import android.app.Application
import com.falin.valentin.approvetestapplication.BuildConfig
import timber.log.Timber

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}