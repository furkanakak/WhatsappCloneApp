package com.furkanakak.whatsappcloneapp.domain.repository

import com.furkanakak.whatsappcloneapp.data.entity.ChatResponse

interface Repository {

    suspend fun  getChatData() : ChatResponse
}