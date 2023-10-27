package com.furkanakak.whatsappcloneapp.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChatResponse(
    @SerialName("allFriends")
    var allFriends: List<AllFriend>?,
    @SerialName("friends")
    var friends: List<Friend>?,
    @SerialName("profile")
    var profile: Profile?
)