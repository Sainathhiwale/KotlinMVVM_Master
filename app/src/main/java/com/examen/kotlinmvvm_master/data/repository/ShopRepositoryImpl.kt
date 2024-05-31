package com.examen.kotlinmvvm_master.data.repository

import com.examen.kotlinmvvm_master.data.model.Category
import com.examen.kotlinmvvm_master.data.model.Login
import com.examen.kotlinmvvm_master.data.model.LoginResponse
import com.examen.kotlinmvvm_master.data.repository.datasource.ShopRemoteDataSource
import com.examen.kotlinmvvm_master.data.utils.Resource
import com.examen.kotlinmvvm_master.domain.repository.ShopRepository
import retrofit2.Response
import javax.inject.Inject

class ShopRepositoryImpl @Inject constructor(private val remoteDataSource: ShopRemoteDataSource): ShopRepository {

    override suspend fun loginUser(login: Login): Resource<LoginResponse> {
        return  responseLoginResult(remoteDataSource.loginUser(login))
    }

    override suspend fun getAllCategories(): Resource<Category> {
        return responseAllCategory(remoteDataSource.getAllCategory())
    }

    // get all category
    private fun responseAllCategory(responseAllCategory: Response<Category>): Resource<Category> {
        if (responseAllCategory.isSuccessful){
            responseAllCategory.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(message = "${responseAllCategory.errorBody()?.string()}")
    }

    //login result
    private fun responseLoginResult(response: Response<LoginResponse>): Resource<LoginResponse> {
        if (response.isSuccessful){
            response.body()?.let {
           return Resource.Success(it)
            }
        }
        return Resource.Error(message = "${response.errorBody()?.string()}")
    }
}