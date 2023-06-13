package com.minutos.tumpi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.minutos.tumpi.ui.screens.Login
import com.minutos.tumpi.ui.screens.login.LoginViewModel
import com.minutos.tumpi.ui.theme.TumpiTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TumpiTheme {
                Login()
            }
        }
    }
}