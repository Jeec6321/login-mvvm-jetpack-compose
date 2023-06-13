package com.minutos.tumpi.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.minutos.tumpi.ui.screens.login.LoginViewModel
import com.minutos.tumpi.ui.screens.login.components.loginBackground
import com.minutos.tumpi.ui.screens.login.components.loginForm
import com.minutos.tumpi.ui.screens.login.components.loginHeader
import com.minutos.tumpi.ui.screens.login.components.loginWelcome

@Composable
fun Login(viewModel: LoginViewModel = hiltViewModel()) {
    loginBackground()

    Column(modifier = Modifier.fillMaxWidth()) {

        loginHeader()

        Card(
            shape = RoundedCornerShape(
                topStart = 40.dp,
                topEnd = 40.dp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
                .fillMaxHeight()
        ) {
            LazyColumn() {
                item { loginWelcome() }
                item { loginForm(viewModel) }
            }
        }
    }
}