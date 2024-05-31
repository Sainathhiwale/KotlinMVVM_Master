package com.examen.kotlinmvvm_master.data.repository.datasource

import com.examen.kotlinmvvm_master.data.model.Category
import com.examen.kotlinmvvm_master.data.model.Login
import com.examen.kotlinmvvm_master.data.model.LoginResponse
import com.examen.kotlinmvvm_master.data.utils.Resource
import retrofit2.Response

interface ShopRemoteDataSource {
    suspend fun loginUser(login: Login):Response<LoginResponse>
    suspend fun getAllCategory():Response<Category>
}