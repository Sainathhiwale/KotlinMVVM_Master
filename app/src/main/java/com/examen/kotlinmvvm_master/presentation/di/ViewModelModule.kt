package com.examen.kotlinmvvm_master.presentation.di

import android.app.Application
import com.examen.kotlinmvvm_master.data.utils.SharedPreference
import com.examen.kotlinmvvm_master.domain.usecase.AuthUseCase
import com.examen.kotlinmvvm_master.domain.usecase.ProductUseCase
import com.examen.kotlinmvvm_master.presentation.viewmodel.HomeViewModel
import com.examen.kotlinmvvm_master.presentation.viewmodel.LoginViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ViewModelModule {

    @Singleton
    @Provides
    fun providesLoginViewModel(authUseCase: AuthUseCase, sharedPreference: SharedPreference) : LoginViewModel {
        return LoginViewModel(authUseCase,sharedPreference)
    }

    @Singleton
    @Provides
    fun provideHomeViewModel(app : Application, productUseCase: ProductUseCase):HomeViewModel{
        return HomeViewModel(app,productUseCase)
    }
}