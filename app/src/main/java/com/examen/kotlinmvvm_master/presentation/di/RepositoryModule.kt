package com.examen.kotlinmvvm_master.presentation.di

import com.examen.kotlinmvvm_master.data.repository.ShopRepositoryImpl
import com.examen.kotlinmvvm_master.data.repository.datasource.ShopRemoteDataSource
import com.examen.kotlinmvvm_master.domain.repository.ShopRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    // provide the dependency object to AuthUseCase class
    @Singleton
    @Provides
    fun providesShopRepository(shopRemoteDataSource: ShopRemoteDataSource):ShopRepository{
         return ShopRepositoryImpl(shopRemoteDataSource)
    }
}