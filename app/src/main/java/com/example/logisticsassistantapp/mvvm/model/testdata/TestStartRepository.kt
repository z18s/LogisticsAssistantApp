package com.example.logisticsassistantapp.mvvm.model.testdata

import com.example.logisticsassistantapp.mvvm.model.datasource.IStartRepository

class TestStartRepository : IStartRepository {
    override fun sendCode(number: String): Boolean = true

    override fun checkCode(code: String): Boolean = (code == "000000")
}