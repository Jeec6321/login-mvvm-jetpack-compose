package com.minutos.tumpi.ui.screens.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.minutos.tumpi.R

@Preview
@Composable
fun loginBackground() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        colorResource(id = R.color.primary_dark),
                        colorResource(id = R.color.primary_dark),
                        colorResource(id = R.color.primary)
                    )
                )
            )
    )
}
