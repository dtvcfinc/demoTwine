package com.dani.demotwine

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dani.demotwine.repositories.GitHub
import timber.log.Timber
import timber.log.Timber.d
import timber.log.Timber.e

/**
 * Created by dani on 3/05/17.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        setContentView(R.layout.activity_main)
        GitHub.getRepos().subscribe({
            list ->
            list.forEach {
                d(it.toString())
            }
        }, ::e)
    }
}