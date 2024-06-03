package com.examen.kotlinmvvm_master.presentation.di

import com.examen.kotlinmvvm_master.presentation.ui.adapter.HomeShopAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {
    @Singleton
    @Provides
    fun providesHomeAdapter():HomeShopAdapter{
        return HomeShopAdapter()
    }
}