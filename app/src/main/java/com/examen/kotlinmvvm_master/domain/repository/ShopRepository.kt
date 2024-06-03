package com.examen.kotlinmvvm_master.domain.repository

import com.examen.kotlinmvvm_master.data.model.category.Category
import com.examen.kotlinmvvm_master.data.model.Login
import com.examen.kotlinmvvm_master.data.model.LoginResponse
import com.examen.kotlinmvvm_master.data.model.allproductshop.Shop
import com.examen.kotlinmvvm_master.data.utils.Resource

interface ShopRepository {

    suspend fun loginUser(login: Login) : Resource<LoginResponse>
    suspend fun getAllCategories() : Resource<Category>
    suspend fun getAllProducts() : Resource<Shop>

}