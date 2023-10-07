package com.example.logisticsassistantapp.application

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.logisticsassistantapp.mvvm.model.datasource.StartRepository
import com.example.logisticsassistantapp.mvvm.viewmodel.MainViewModel

class LogisticsAssistantApp: Application() {

    val viewModelFactory: ViewModelProvider.Factory = viewModelFactory {
        initializer {
            MainViewModel(startRepository = StartRepository())
        }
    }

    companion object {
        @Volatile private var instance: LogisticsAssistantApp? = null

        fun instance() = instance ?: synchronized(this) {
            LogisticsAssistantApp().also { instance = it }
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}