package com.minutos.tumpi.domain.usecases.user

import com.minutos.tumpi.domain.model.User
import com.minutos.tumpi.domain.repository.UserRepository
import javax.inject.Inject

class FindUserUseCase @Inject constructor(
    private val repository: UserRepository
){

    suspend operator fun invoke(email: String, password: String): User? {
        return repository.findUser(email, password)
    }

}