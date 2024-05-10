package com.ougi.callme.presentation.routing.model

import kotlinx.serialization.Serializable

@Serializable
class UpdateUserRequest(
    val login: String,
    val token: String,
)