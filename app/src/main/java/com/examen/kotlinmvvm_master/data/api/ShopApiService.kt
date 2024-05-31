package com.examen.kotlinmvvm_master.data.api

import com.examen.kotlinmvvm_master.data.model.Login
import com.examen.kotlinmvvm_master.data.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ShopApiService {
    //Login user
    @POST("auth/login")
    suspend fun loginUser(@Body login : Login): Response<LoginResponse>

    //Register user
   /* @POST("users")
    suspend fun registerUser(@Body user : User): Response<User>

    // Home - get all product
    @GET("/products")
    suspend fun getAllProducts() : Response<Shop>

    @GET("products/categories")
    suspend fun getAllCategories() : Response<Category>*/
}