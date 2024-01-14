package com.furkanakak.whatsappcloneapp.screen.mainscreen.chats_screen

import com.furkanakak.whatsappcloneapp.data.entity.ChatResponse

data class ChatsState (
    val loading: Boolean = false,
    val success: ChatResponse? = null,
    val error: String? = null
)