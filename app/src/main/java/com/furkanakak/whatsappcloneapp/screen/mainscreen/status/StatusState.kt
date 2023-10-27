package com.furkanakak.whatsappcloneapp.screen.mainscreen.status

import com.furkanakak.whatsappcloneapp.data.entity.ChatResponse

data class StatusState (
    val loading: Boolean = false,
    val success: ChatResponse? = null,
    val error: String? = null
)