package com.minutos.tumpi.ui.screens.login.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.minutos.tumpi.R
import com.minutos.tumpi.ui.components.*
import com.minutos.tumpi.ui.screens.login.LoginEvent
import com.minutos.tumpi.ui.screens.login.LoginMessages
import com.minutos.tumpi.ui.screens.login.LoginViewModel
import kotlinx.coroutines.launch

@Composable
fun loginForm(viewModel: LoginViewModel) {
    val state by viewModel.state.collectAsState()

    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.padding(horizontal = 20.dp)) {
        MainField(
            label = stringResource(id = R.string.Email),
            input = state.email,
            type = KeyboardType.Email,
            onChangeListener = {
                viewModel.onEvent(LoginEvent.EmailChanged(it))
            },
            isEnabled = state.isLoading.not(),
            modifier = Modifier.padding(top = 16.dp)
        )

        if (state.emailError == LoginMessages.EMAIL_FORMAT_ERROR) {
            TextView(
                text = stringResource(id = R.string.email_format_error),
                size = 14.sp,
                color = Color.Red,
                textAlign = TextAlign.Left,
                modifier = Modifier.fillMaxWidth()
            )
        }

        MainField(
            label = stringResource(id = R.string.Password),
            input = state.password,
            type = KeyboardType.Password,
            onChangeListener = {
               viewModel.onEvent(LoginEvent.PasswordChanged(it))
            },
            isEnabled = state.isLoading.not(),
            modifier = Modifier.padding(top = 16.dp)
        )

        if (state.passwordError == LoginMessages.PASSWORD_SIZE_ERROR) {
            TextView(
                text = stringResource(id = R.string.password_length_error),
                color = Color.Red,
                size = 14.sp,
                textAlign = TextAlign.Left,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                CheckBoxView(
                    isChecked = state.rememberMe,
                    listener = { viewModel.onEvent(LoginEvent.RememberMeChanged(it)) },
                    isEnabled = state.isLoading.not()
                )

                TextView(text = stringResource(id = R.string.remember_me), size = 14.sp)
            }

            TextView(
                text = stringResource(id = R.string.password_forget),
                size = 14.sp,
                color = colorResource(id = if (state.isLoading.not()) R.color.primary else R.color.soft_text),
                modifier = Modifier.clickable {
                    if (state.isLoading.not()) goToForgotPassword()
                }
            )
        }

        MainButton(
            text = stringResource(id = R.string.login),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            isEnabled = state.btnEnabled,
            isLoading = state.isLoading
        ) {
            coroutineScope.launch { viewModel.login() }
        }

        SecondaryButton(
            text = stringResource(id = R.string.create_account),
            modifier = Modifier.padding(vertical = 16.dp),
            isEnabled = state.isLoading.not()
        ) {
            goToCreateAccount()
        }
    }
}

fun goToForgotPassword() {}

fun goToCreateAccount() {}