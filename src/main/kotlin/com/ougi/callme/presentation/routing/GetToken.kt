package com.ougi.callme.presentation.routing

import com.ougi.callme.domain.usecase.GetUserTokenUseCase
import com.ougi.callme.presentation.routing.model.GetUserTokenRequest
import com.ougi.callme.presentation.routing.model.UserTokenResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.getUserToken() {
    val getUserTokenUseCase by inject<GetUserTokenUseCase>()
    get("/getToken") {
        val request = call.receive<GetUserTokenRequest>()
        getUserTokenUseCase.getToken(request.login)
            ?.let { token ->
                call.respond(
                    status = HttpStatusCode.OK,
                    message = UserTokenResponse(token)
                )
            }
            ?: call.respond(HttpStatusCode.NoContent)
    }
}