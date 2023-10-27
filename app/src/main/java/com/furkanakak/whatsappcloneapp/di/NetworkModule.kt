package com.furkanakak.whatsappcloneapp.di

import com.furkanakak.whatsappcloneapp.data.remote.ApiService
import com.furkanakak.whatsappcloneapp.data.remote.ApiServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.features.DefaultRequest
import io.ktor.client.features.HttpTimeout
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.http.URLProtocol


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {


    @Provides
    fun provideKtorClient(): HttpClient {
        return HttpClient(OkHttp) {
            install(JsonFeature) {
                serializer = KotlinxSerializer()
            }
            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }
            install(DefaultRequest) {

                url {
                    protocol = URLProtocol.HTTPS
                }
            }
            install(HttpTimeout)
        }
    }

    @Provides
    fun provideApiService(httpClient: HttpClient): ApiService {
        return ApiServiceImpl(httpClient)
    }
}