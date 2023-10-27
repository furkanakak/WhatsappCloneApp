package com.furkanakak.whatsappcloneapp.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FriendX(
    @SerialName("id")
    var id: Int?,
    @SerialName("lastChat")
    var lastChat: String?,
    @SerialName("latest_timestamp")
    var latestTimestamp: String?,
    @SerialName("name")
    var name: String?,
    @SerialName("picture")
    var picture: String?
)