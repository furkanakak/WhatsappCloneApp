package com.furkanakak.whatsappcloneapp.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Chatlog(
    @SerialName("message_id")
    var messageId: Int?,
    @SerialName("side")
    var side: String,
    @SerialName("text")
    var text: String?,
    @SerialName("timestamp")
    var timestamp: String?
)