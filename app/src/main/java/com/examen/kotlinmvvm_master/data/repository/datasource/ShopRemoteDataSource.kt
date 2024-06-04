package com.examen.kotlinmvvm_master.data.repository.datasource

import com.examen.kotlinmvvm_master.data.model.category.Category
import com.examen.kotlinmvvm_master.data.model.Login
import com.examen.kotlinmvvm_master.data.model.LoginResponse
import com.examen.kotlinmvvm_master.data.model.allproductshop.Shop
import retrofit2.Response
import retrofit2.http.Path

interface ShopRemoteDataSource {
    suspend fun loginUser(login: Login):Response<LoginResponse>
    suspend fun getAllCategory():Response<Category>
    suspend fun getAllProduct():Response<Shop>
    suspend fun getCategoryProducts(category:String):Response<Shop>

}