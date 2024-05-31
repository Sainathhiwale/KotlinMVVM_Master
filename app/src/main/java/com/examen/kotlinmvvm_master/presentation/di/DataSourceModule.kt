package com.examen.kotlinmvvm_master.presentation.di

import com.examen.kotlinmvvm_master.data.api.ShopApiService
import com.examen.kotlinmvvm_master.data.repository.datasource.ShopRemoteDataSource
import com.examen.kotlinmvvm_master.data.repository.datasourceImpl.ShopRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    // provide the dependency object to ShopRepositoryImpl class
    @Singleton
    @Provides
    fun provideShopRemoteDataSource(shopApiService: ShopApiService):ShopRemoteDataSource{
        return ShopRemoteDataSourceImpl(shopApiService)
    }
}