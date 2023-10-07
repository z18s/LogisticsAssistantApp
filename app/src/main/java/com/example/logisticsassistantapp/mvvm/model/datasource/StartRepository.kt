package com.example.logisticsassistantapp.mvvm.model.datasource

import com.example.logisticsassistantapp.mvvm.model.testdata.TestStartRepository

class StartRepository : IStartRepository {

    // Test Repository
    private val repo : IStartRepository = TestStartRepository()

    override fun sendCode(number: String): Boolean = repo.sendCode(number)

    override fun checkCode(code: String): Boolean = repo.checkCode(code)
}