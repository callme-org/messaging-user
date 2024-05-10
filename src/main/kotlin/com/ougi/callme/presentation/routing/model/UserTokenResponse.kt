package com.ougi.callme.presentation.routing.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserTokenResponse(
    @SerialName("token")
    val token: String
)