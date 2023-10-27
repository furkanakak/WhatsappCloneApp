package com.furkanakak.whatsappcloneapp.data.remote

import com.furkanakak.whatsappcloneapp.data.entity.ChatResponse


interface ApiService {

    suspend fun getChatData(): ChatResponse
}