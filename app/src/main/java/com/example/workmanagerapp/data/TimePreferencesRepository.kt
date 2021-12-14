package com.example.workmanagerapp.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.workmanagerapp.data.TimePreferencesRepository.PreferencesKeys.CLIENT_IP
import com.example.workmanagerapp.data.TimePreferencesRepository.PreferencesKeys.DATETIME
import kotlinx.coroutines.flow.first


class TimePreferencesRepository(private val dataStore: DataStore<Preferences>) {

    private object PreferencesKeys {
        val DATETIME = stringPreferencesKey("datetime")
        val CLIENT_IP = stringPreferencesKey("client_ip")
    }

    suspend fun setDatetime(datetime: String) {
        dataStore.edit { dataStore ->
            dataStore[DATETIME] = datetime
        }
    }

    suspend fun getDatetime(): String {
        return dataStore.data.first()[DATETIME] ?: ""
    }

    suspend fun setClientIp(ip: String) {
        dataStore.edit { dataStore ->
            dataStore[CLIENT_IP] = ip
        }
    }

    suspend fun getClientIp(): String {
        return dataStore.data.first()[CLIENT_IP] ?: ""
    }
}