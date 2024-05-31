package com.examen.kotlinmvvm_master.domain.usecase

import android.util.Log
import com.examen.kotlinmvvm_master.data.model.Login
import com.examen.kotlinmvvm_master.data.model.LoginResponse
import com.examen.kotlinmvvm_master.data.utils.Resource
import com.examen.kotlinmvvm_master.domain.repository.ShopRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class AuthUseCase @Inject constructor( private val repository: ShopRepository){

    fun loginUser(username : String, password : String) : Flow<Resource<LoginResponse>> = flow{
        emit(Resource.Loading())
        try {
            val login = Login(username, password)
            val response = repository.loginUser(login)
            Log.i("AuthUseCase","I dey here, ${response.data?.token}")
            emit (response)
        }catch (e : HttpException){
            Log.i("AuthUseCase","${e.localizedMessage}")
            emit (Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }catch (e : IOException){
            Log.i("AuthUseCase","${e.localizedMessage}")
            emit (Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}