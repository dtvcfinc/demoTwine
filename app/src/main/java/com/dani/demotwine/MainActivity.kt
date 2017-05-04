package com.dani.demotwine

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dani.demotwine.repo_list.RepoListView
import timber.log.Timber

/**
 * Created by dani on 3/05/17.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        supportFragmentManager.beginTransaction()
                .replace(android.R.id.content, RepoListView())
                .commit()
    }
}