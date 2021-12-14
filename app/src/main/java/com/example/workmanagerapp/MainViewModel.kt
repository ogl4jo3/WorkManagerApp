package com.example.workmanagerapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.workmanagerapp.api.WorldTimeApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val apiService: WorldTimeApiService
) : ViewModel() {
    val message = MutableLiveData("test")

    init {
        runBlocking {//TODO: workaround, for test
            message.value = apiService.fetchWorldTime().body()?.datetime
        }
    }
}