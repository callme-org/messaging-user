package com.ougi.callme.data.repository

import com.ougi.callme.data.model.dto.CreateUserDto
import com.ougi.callme.data.model.table.MessagingUsers
import com.ougi.callme.domain.repository.MessagingUsersRepository
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.update

class MessagingUsersRepositoryImpl : MessagingUsersRepository {

    override suspend fun createOrUpdate(user: CreateUserDto) {
        dbQuery {
            val isUserExits = MessagingUsers.selectAll()
                .where { MessagingUsers.login eq user.login }
                .count() > 0
            if (isUserExits) update(user.login, user.firebaseToken)
            else MessagingUsers.insert { column ->
                column[login] = user.login
                column[firebaseToken] = user.firebaseToken
            }[MessagingUsers.login]
        }
    }

    override suspend fun update(
        login: String,
        newFirebaseToken: String
    ) {
        dbQuery {
            MessagingUsers.update({ MessagingUsers.login eq login }) { column ->
                column[firebaseToken] = newFirebaseToken
            }
        }
    }

    override suspend fun getTokenByLogin(login: String) = dbQuery {
        MessagingUsers.selectAll()
            .where { MessagingUsers.login eq login }
            .map { result -> result[MessagingUsers.firebaseToken] }
            .firstOrNull()
    }

    private suspend fun <T> dbQuery(query: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { query() }

}