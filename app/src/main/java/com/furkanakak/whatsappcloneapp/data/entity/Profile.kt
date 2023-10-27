package com.furkanakak.whatsappcloneapp.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Profile(
    @SerialName("friends")
    var friends: List<FriendX>?,
    @SerialName("id")
    var id: Int?,
    @SerialName("name")
    var name: String?,
    @SerialName("picture")
    var picture: String?,
    @SerialName("status")
    var status: String?
)