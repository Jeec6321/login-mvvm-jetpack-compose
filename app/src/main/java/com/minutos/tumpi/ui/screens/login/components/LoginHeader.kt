package com.minutos.tumpi.ui.screens.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.minutos.tumpi.R
import com.minutos.tumpi.ui.components.TextView
import com.minutos.tumpi.ui.components.TitleView

@Preview
@Composable
fun loginHeader() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.tumpilogo),
            contentDescription = "",
            modifier = Modifier.fillMaxWidth().padding(20.dp)
        )

        TitleView(
            text = stringResource(id = R.string.app_name),
            color = Color.White,
            size = 35.sp,
            modifier = Modifier.fillMaxWidth()
        )

        TextView(
            text = stringResource(id = R.string.slogan),
            size = 12.sp,
            color = Color.White,
            modifier = Modifier.fillMaxWidth()
        )
    }
}