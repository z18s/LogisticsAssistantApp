package com.example.logisticsassistantapp.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.logisticsassistantapp.mvvm.model.datasource.IStartRepository

class MainViewModel(private val startRepository: IStartRepository) : ViewModel() {

    private val _topBarTabText: MutableLiveData<String> = MutableLiveData()
    private val _phoneNumberEntered: MutableLiveData<Boolean> = MutableLiveData()
    private val _loginCodeEntered: MutableLiveData<Boolean> = MutableLiveData()
    private val _loginCodeChecked: MutableLiveData<Boolean> = MutableLiveData()

    val topBarTabText: LiveData<String> = _topBarTabText
    val phoneNumberEntered: LiveData<Boolean> = _phoneNumberEntered
    val loginCodeEntered: LiveData<Boolean> = _loginCodeEntered
    val loginCodeChecked: LiveData<Boolean> = _loginCodeChecked

    fun onTopBarTabTextChange(text: String) {
        _topBarTabText.value = text
    }

    fun onPhoneNumberEntered(phoneNumber: String) {
        _phoneNumberEntered.value = startRepository.sendCode(phoneNumber)
    }

    fun onPhoneNumberReentered() {
        _phoneNumberEntered.value = false
    }

    fun onLoginCodeEntered(loginCode: String) {
        _loginCodeEntered.value = true
        onLoginCodeChecked(loginCode)
    }

    fun onLoginCodeReentered() {
        _loginCodeEntered.value = false
    }

    private fun onLoginCodeChecked(loginCode: String) {
        _loginCodeChecked.value = startRepository.checkCode(loginCode)
    }
}