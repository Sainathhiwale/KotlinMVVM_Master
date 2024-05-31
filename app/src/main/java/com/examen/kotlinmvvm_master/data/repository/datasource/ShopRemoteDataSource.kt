package com.examen.kotlinmvvm_master.data.repository.datasource

import com.examen.kotlinmvvm_master.data.model.Login
import com.examen.kotlinmvvm_master.data.model.LoginResponse
import retrofit2.Response

interface ShopRemoteDataSource {
    suspend fun loginUser(login: Login):Response<LoginResponse>
}