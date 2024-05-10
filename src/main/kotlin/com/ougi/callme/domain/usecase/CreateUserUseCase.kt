package com.ougi.callme.domain.usecase

import com.ougi.callme.data.model.dto.CreateUserDto
import com.ougi.callme.domain.repository.MessagingUsersRepository

interface CreateUserUseCase {

    suspend fun create(
        login: String,
        token: String
    )
}

class CreateUserUseCaseImpl(
    private val messagingUsersRepository: MessagingUsersRepository
) : CreateUserUseCase {

    override suspend fun create(
        login: String,
        token: String
    ) =
        messagingUsersRepository.createOrUpdate(
            CreateUserDto(
                login = login,
                firebaseToken = token,
            )
        )

}