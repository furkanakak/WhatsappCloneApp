package com.furkanakak.whatsappcloneapp.screen.mainscreen.calls_screen

import com.furkanakak.whatsappcloneapp.data.entity.ChatResponse

data class RecentState(
    val loading: Boolean = false,
    val success: ChatResponse? = null,
    val error: String? = null
)

