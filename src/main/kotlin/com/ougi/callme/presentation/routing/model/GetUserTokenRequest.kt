package com.ougi.callme.presentation.routing.model

import kotlinx.serialization.Serializable

@Serializable
class GetUserTokenRequest(
    val login: String
)