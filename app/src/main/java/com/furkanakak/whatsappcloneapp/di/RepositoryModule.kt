package com.furkanakak.whatsappcloneapp.di

import com.furkanakak.whatsappcloneapp.data.entity.ChatResponse
import com.furkanakak.whatsappcloneapp.data.remote.ApiService
import com.furkanakak.whatsappcloneapp.data.repository.RepositoryImpl
import com.furkanakak.whatsappcloneapp.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(apiService: ApiService): Repository {
        return RepositoryImpl(apiService)
    }

}