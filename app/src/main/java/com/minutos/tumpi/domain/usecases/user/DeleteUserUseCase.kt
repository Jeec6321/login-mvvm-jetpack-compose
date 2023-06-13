package com.minutos.tumpi.domain.usecases.user

import com.minutos.tumpi.domain.model.User
import com.minutos.tumpi.domain.repository.UserRepository
import javax.inject.Inject

class DeleteUserUseCase @Inject constructor(
    private val repository: UserRepository
) {

    suspend operator fun invoke(user: User) {
        return repository.deleteUser(user)
    }

}