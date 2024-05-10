package com.ougi.callme.presentation.routing

import com.ougi.callme.domain.usecase.UpdateUserUseCase
import com.ougi.callme.presentation.routing.model.UpdateUserRequest
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.updateUser() {
    val updateUserUseCase by inject<UpdateUserUseCase>()
    post("/update") {
        val request = call.receive<UpdateUserRequest>()
        updateUserUseCase.update(
            login = request.login,
            newToken = request.token,
        )
        call.respond(HttpStatusCode.OK)
    }
}