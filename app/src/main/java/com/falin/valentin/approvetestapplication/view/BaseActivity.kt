package com.falin.valentin.approvetestapplication.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i(("$localClassName onCreate called"))
    }

    override fun onStart() {
        super.onStart()
        Timber.i("$localClassName onStart called")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("$localClassName onResume called")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.i("$localClassName onRestart called")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("$localClassName onPause called")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("$localClassName onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("$localClassName onDestroy called")
    }
}