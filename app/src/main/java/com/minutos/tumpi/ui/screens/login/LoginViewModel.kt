package com.minutos.tumpi.ui.screens.login

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.minutos.tumpi.domain.model.User
import com.minutos.tumpi.domain.usecases.user.FindUserUseCase
import com.minutos.tumpi.domain.usecases.user.GetUserUseCase
import com.minutos.tumpi.domain.usecases.user.InsertUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val findUserUseCase: FindUserUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state.asStateFlow()


    fun validateData(email: String, password: String) {
        _state.value = _state.value.copy(email = email.replace(" ", ""))

        _state.value = _state.value.copy(password = password.replace(" ", ""))

        val isEmailFormatValid = Patterns.EMAIL_ADDRESS.matcher(_state.value.email).matches()

        val isPasswordLengthValid = (state.value.password.length ?: 0) >= 8

        if (!isEmailFormatValid && !_state.value.email.isNullOrEmpty())
            _state.value = _state.value.copy(emailError = LoginMessages.EMAIL_FORMAT_ERROR)
        else
            _state.value = _state.value.copy(emailError = LoginMessages.NONE)

        if (!isPasswordLengthValid && !state.value.password.isNullOrEmpty())
            _state.value = _state.value.copy(passwordError = LoginMessages.PASSWORD_SIZE_ERROR)
        else
            _state.value = _state.value.copy(passwordError = LoginMessages.NONE)

        _state.value = _state.value.copy(btnEnabled = isEmailFormatValid && isPasswordLengthValid)
    }

    suspend fun login(): Boolean {
        _state.value = _state.value.copy(isLoading = true)

        val user2 = findUserUseCase(
            _state.value.email,
            _state.value.password
        )

        _state.value = _state.value.copy(isLoading = false)

        return user2 != null
    }

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.EmailChanged -> {
                _state.value = _state.value.copy(email = event.email)

                validateData(_state.value.email, _state.value.password)
            }

            is LoginEvent.PasswordChanged -> {
                _state.value = _state.value.copy(password = event.password)

                validateData(_state.value.email, _state.value.password)
            }

            is LoginEvent.RememberMeChanged -> {
                _state.value = _state.value.copy(rememberMe = event.remember)
            }
        }
    }
}

data class LoginState(
    val email: String = "",
    val password: String = "",
    val btnEnabled: Boolean = false,
    val isLoading: Boolean = false,
    val rememberMe: Boolean = false,
    val emailError: LoginMessages = LoginMessages.NONE,
    val passwordError: LoginMessages = LoginMessages.NONE
)

sealed class LoginEvent {
    class EmailChanged(val email: String) : LoginEvent()
    class PasswordChanged(val password: String) : LoginEvent()
    class RememberMeChanged(val remember: Boolean) : LoginEvent()
}

enum class LoginMessages {
    EMAIL_FORMAT_ERROR,
    PASSWORD_SIZE_ERROR,
    NONE
}