package com.ougi.callme.data.model.table

import org.jetbrains.exposed.sql.Table

object MessagingUsers : Table("messaging_users") {

    val login = varchar("login", 128)
    val firebaseToken = varchar("firebaseToken", 128)

    override val primaryKey = PrimaryKey(login)
}