package com.minutos.tumpi.domain.usecases.user

import com.minutos.tumpi.domain.model.User
import com.minutos.tumpi.domain.repository.UserRepository
import javax.inject.Inject

class GetAllUsersUseCase @Inject constructor(
    private val repository: UserRepository
){

    suspend operator fun invoke(): List<User> {
        return repository.getAllUsers()
    }

}