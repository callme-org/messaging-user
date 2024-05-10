package com.ougi.callme.presentation.routing.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class GetUserTokenRequest(
    @SerialName("login")
    val login: String
)