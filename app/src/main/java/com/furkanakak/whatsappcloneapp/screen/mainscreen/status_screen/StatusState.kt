package com.furkanakak.whatsappcloneapp.screen.mainscreen.status_screen

import com.furkanakak.whatsappcloneapp.data.entity.ChatResponse

data class StatusState(
    val loading: Boolean = false,
    val error: String? = null,
    val success: ChatResponse? = null
)