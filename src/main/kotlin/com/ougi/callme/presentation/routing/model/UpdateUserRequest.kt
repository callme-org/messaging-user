package com.ougi.callme.presentation.routing.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UpdateUserRequest(
    @SerialName("login")
    val login: String,
    @SerialName("token")
    val token: String,
)