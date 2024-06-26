package com.examen.kotlinmvvm_master.presentation.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideSharedPreference(@ApplicationContext context: Context):SharedPreferences{
        return context.getSharedPreferences("shopPref",Context.MODE_PRIVATE)
    }
}