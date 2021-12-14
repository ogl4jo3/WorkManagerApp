package com.example.workmanagerapp.ui

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.preferences.preferencesDataStore
import com.example.workmanagerapp.R
import dagger.hilt.android.AndroidEntryPoint

private const val PREFERENCES_NAME = "work_manager_app"
val Context.dataStore by preferencesDataStore(PREFERENCES_NAME)

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container_view, MainFragment.newInstance())
                .commit()
        }
    }
}