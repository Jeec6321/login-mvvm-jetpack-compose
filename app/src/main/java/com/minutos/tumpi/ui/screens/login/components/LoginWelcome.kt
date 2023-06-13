package com.minutos.tumpi.ui.screens.login.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.minutos.tumpi.R
import com.minutos.tumpi.ui.components.SoftTextView
import com.minutos.tumpi.ui.components.TitleView

@Preview
@Composable
fun loginWelcome() {
    Column {
        TitleView(
            text = stringResource(id = R.string.welcome),
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        )

        SoftTextView(
            text = stringResource(id = R.string.fill_form_text),
            size = 12.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
        )
    }
}