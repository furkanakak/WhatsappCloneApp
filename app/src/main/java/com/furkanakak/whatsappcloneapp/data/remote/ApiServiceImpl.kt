package com.furkanakak.whatsappcloneapp.data.remote



import android.util.Log
import com.furkanakak.whatsappcloneapp.common.Constants
import com.furkanakak.whatsappcloneapp.data.entity.ChatResponse
import com.furkanakak.whatsappcloneapp.data.remote.ApiService
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class ApiServiceImpl(private val httpClient: HttpClient): ApiService {

     override suspend fun getChatData(): ChatResponse {
         return httpClient.get("${Constants.BASE_URL}.json")
     }


}