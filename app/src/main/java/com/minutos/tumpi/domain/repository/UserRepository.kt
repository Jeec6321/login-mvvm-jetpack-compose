package com.minutos.tumpi.domain.repository

import com.minutos.tumpi.domain.model.User

interface UserRepository {
    suspend fun getAllUsers(): List<User>

    suspend fun getUserById(id: Int): User?

    suspend fun insertUser(user: User)

    suspend fun deleteUser(user: User)

    suspend fun findUser(email: String, password: String): User?
}