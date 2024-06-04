package com.examen.kotlinmvvm_master.data.api

import com.examen.kotlinmvvm_master.data.model.category.Category
import com.examen.kotlinmvvm_master.data.model.Login
import com.examen.kotlinmvvm_master.data.model.LoginResponse
import com.examen.kotlinmvvm_master.data.model.allproductshop.Shop
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ShopApiService {
    //Login user
    @POST("auth/login")
    suspend fun loginUser(@Body login : Login): Response<LoginResponse>

    //homefragment get all category
    @GET("products/categories")
    suspend fun getAllCategories() : Response<Category>
    // homefragment get all product
    @GET("/products")
    suspend fun getAllProducts (): Response<Shop>
    // home fragment get all product category which is selected on home page
    @GET("/products/category/{category}")
    suspend fun getCategoryProducts(@Path(value = "category") category:String):Response<Shop>
    //Register user
   /* @POST("users")
    suspend fun registerUser(@Body user : User): Response<User>

    // Home - get all product
    @GET("/products")
    suspend fun getAllProducts() : Response<Shop>

    @GET("products/categories")
    suspend fun getAllCategories() : Response<Category>*/
}