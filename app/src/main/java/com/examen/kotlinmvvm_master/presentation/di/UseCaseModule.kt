package com.examen.kotlinmvvm_master.presentation.di

import com.examen.kotlinmvvm_master.domain.repository.ShopRepository
import com.examen.kotlinmvvm_master.domain.usecase.AuthUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {


    @Singleton
    @Provides
    fun providesAuthUseCase(repository: ShopRepository):AuthUseCase{
        return  AuthUseCase(repository)
    }
}