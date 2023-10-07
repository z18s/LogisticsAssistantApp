package com.example.logisticsassistantapp.mvvm.model.datasource

interface IStartRepository : IRepository {
    fun sendCode(number: String): Boolean
    fun checkCode(code: String): Boolean
}