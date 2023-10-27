package com.furkanakak.whatsappcloneapp.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Friend(
    @SerialName("chatlog")
    var chatlog: List<Chatlog> = listOf(),
    @SerialName("id")
    var id: Int?,
    @SerialName("name")
    var name: String?,
    @SerialName("picture")
    var picture: String?
)