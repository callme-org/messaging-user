package com.ougi.callme.di

import com.ougi.callme.data.repository.DatabaseRepositoryImpl
import com.ougi.callme.data.repository.MessagingUsersRepositoryImpl
import com.ougi.callme.domain.repository.DatabaseRepository
import com.ougi.callme.domain.repository.MessagingUsersRepository
import com.ougi.callme.domain.usecase.*
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

private val dataModule = module {
    singleOf(::DatabaseRepositoryImpl) { bind<DatabaseRepository>() }
    singleOf(::MessagingUsersRepositoryImpl) { bind<MessagingUsersRepository>() }
}

private val domainModule = module {
    singleOf(::DatabaseInitializerImpl) { bind<DatabaseInitializer>() }
    singleOf(::CreateUserUseCaseImpl) { bind<CreateUserUseCase>() }
    singleOf(::UpdateUserUseCaseImpl) { bind<UpdateUserUseCase>() }
    singleOf(::GetUserTokenUseCaseImpl) { bind<GetUserTokenUseCase>() }
}


val appModule = module {
    includes(
        dataModule,
        domainModule
    )
}