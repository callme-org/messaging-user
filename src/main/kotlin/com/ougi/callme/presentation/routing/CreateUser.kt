package com.ougi.callme.presentation.routing

import com.ougi.callme.domain.usecase.CreateUserUseCase
import com.ougi.callme.presentation.routing.model.UpdateUserRequest
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.createUser() {
    val createUserUseCase by inject<CreateUserUseCase>()
    post("/create") {
        val request = call.receive<UpdateUserRequest>()
        createUserUseCase.create(
            login = request.login,
            token = request.token
        )
        call.respond(HttpStatusCode.OK)
    }
}