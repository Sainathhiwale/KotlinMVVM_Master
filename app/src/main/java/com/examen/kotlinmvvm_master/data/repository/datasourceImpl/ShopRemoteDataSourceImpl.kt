package com.examen.kotlinmvvm_master.data.repository.datasourceImpl

import com.examen.kotlinmvvm_master.data.api.ShopApiService
import com.examen.kotlinmvvm_master.data.model.category.Category
import com.examen.kotlinmvvm_master.data.model.Login
import com.examen.kotlinmvvm_master.data.model.LoginResponse
import com.examen.kotlinmvvm_master.data.repository.datasource.ShopRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class ShopRemoteDataSourceImpl @Inject constructor(private val apiService: ShopApiService) : ShopRemoteDataSource {

    override suspend fun loginUser(login: Login): Response<LoginResponse> {
        return apiService.loginUser(login)
    }

    override suspend fun getAllCategory(): Response<Category> {
        return apiService.getAllCategories()
    }
}