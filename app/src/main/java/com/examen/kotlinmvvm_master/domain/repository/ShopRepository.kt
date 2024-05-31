package com.examen.kotlinmvvm_master.domain.repository

import com.examen.kotlinmvvm_master.data.model.Login
import com.examen.kotlinmvvm_master.data.model.LoginResponse
import com.examen.kotlinmvvm_master.data.utils.Resource

interface ShopRepository {
    suspend fun loginUser(login: Login) : Resource<LoginResponse>
}