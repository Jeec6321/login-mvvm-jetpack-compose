package com.minutos.tumpi.data.repository

import com.minutos.tumpi.data.local.UserDao
import com.minutos.tumpi.domain.model.User
import com.minutos.tumpi.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dao: UserDao
): UserRepository {

    override suspend fun getAllUsers(): List<User> = dao.getAllUsers()

    override suspend fun getUserById(id: Int): User? = dao.getUserById(id)

    override suspend fun insertUser(user: User) = dao.insertUser(user)

    override suspend fun deleteUser(user: User) = dao.deleteUser(user)

    override suspend fun findUser(email: String, password: String): User? = dao.findUser(email, password)

}