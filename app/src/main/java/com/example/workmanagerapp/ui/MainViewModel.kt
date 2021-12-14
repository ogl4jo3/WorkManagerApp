package com.example.workmanagerapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workmanagerapp.api.WorldTimeApiService
import com.example.workmanagerapp.data.TimePreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val apiService: WorldTimeApiService,
    private val timePreferencesRepository: TimePreferencesRepository
) : ViewModel() {

    val datetime = MutableLiveData<String>()
    val clientIp = MutableLiveData<String>()

    fun getPreferencesDatetime() {
        viewModelScope.launch {
            datetime.value = timePreferencesRepository.getDatetime()
            clientIp.value = timePreferencesRepository.getClientIp()
        }
    }

    fun fetchAsiaTaipeiTime() {
        viewModelScope.launch {
            apiService.fetchAsiaTaipeiTime().body()?.apply {
                timePreferencesRepository.setDatetime(datetime)
                timePreferencesRepository.setClientIp(clientIp)
            }
        }
    }
}