package com.minutos.tumpi.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.minutos.tumpi.R

@Composable
fun MainButton(
    text: String,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    isLoading: Boolean = false,
    listener: () -> Unit
) {
    Button(
        onClick = { listener() },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = R.color.primary_dark),
            disabledBackgroundColor = colorResource(id = R.color.soft_text),
            contentColor = Color.White,
            disabledContentColor = Color.Black
        ),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 5.dp,
            pressedElevation = 8.dp,
            disabledElevation = 5.dp
        ),
        shape = RoundedCornerShape(40),
        modifier = modifier,
        enabled = isEnabled
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                color = colorResource(id = R.color.white),
                modifier = Modifier.fillMaxHeight()
            )
        } else {
            TextView(
                text = text,
                size = 16.sp,
                weight = FontWeight.Bold,
                family = FontFamily.Monospace,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 20.dp)
            )
        }
    }
}

@Composable
fun SecondaryButton(
    text: String,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    isLoading: Boolean = false,
    listener: () -> Unit
) {
    val borderColor = colorResource(id = if (isEnabled) R.color.primary_dark else R.color.soft_text)

    OutlinedButton(
        onClick = { listener() },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            disabledBackgroundColor = Color.White,
            contentColor = Color.Black,
            disabledContentColor = colorResource(id = R.color.soft_text),
        ),
        border = BorderStroke(
            0.5.dp,
            borderColor
        ),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 5.dp,
            pressedElevation = 8.dp,
            disabledElevation = 5.dp
        ),
        shape = RoundedCornerShape(40),
        modifier = modifier,
        enabled = isEnabled
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                color = colorResource(id = R.color.white),
                modifier = Modifier.fillMaxHeight()
            )
        } else {
            TextView(
                text = text,
                size = 16.sp,
                weight = FontWeight.Bold,
                family = FontFamily.Monospace,
                color = if (isEnabled) Color.Black else colorResource(id = R.color.soft_text),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 20.dp)
            )
        }
    }
}