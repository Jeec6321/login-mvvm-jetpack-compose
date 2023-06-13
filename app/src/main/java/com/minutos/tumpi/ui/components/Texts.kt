package com.minutos.tumpi.ui.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.minutos.tumpi.R

@Composable
fun TitleView(
    text: String,
    size: TextUnit = 30.sp,
    weight: FontWeight = FontWeight.Bold,
    family: FontFamily = FontFamily.Monospace,
    textAlign: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier,
    color: Color = Color.Blue
) {
    Text(
        text = text,
        fontSize = size,
        fontWeight = weight,
        fontFamily = family,
        textAlign = textAlign,
        modifier = modifier,
        color = color
    )
}

@Composable
fun TextView(
    text: String,
    size: TextUnit = 16.sp,
    weight: FontWeight = FontWeight.Bold,
    family: FontFamily = FontFamily.Monospace,
    textAlign: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier,
    color: Color = Color.Black
) {
    Text(
        text = text,
        fontSize = size,
        fontWeight = weight,
        fontFamily = family,
        textAlign = textAlign,
        modifier = modifier,
        color = color
    )
}

@Composable
fun SoftTextView(
    text: String,
    size: TextUnit = 16.sp,
    weight: FontWeight = FontWeight.Bold,
    family: FontFamily = FontFamily.Monospace,
    textAlign: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier,
    color: Color = colorResource(id = R.color.soft_text)
) {
    Text(
        text = text,
        fontSize = size,
        fontWeight = weight,
        fontFamily = family,
        textAlign = textAlign,
        modifier = modifier,
        color = color
    )
}