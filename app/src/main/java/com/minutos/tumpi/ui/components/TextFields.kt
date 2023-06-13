package com.minutos.tumpi.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.minutos.tumpi.R

@Composable
fun MainField(
    label: String,
    input: String,
    onChangeListener: (String) -> Unit,
    type: KeyboardType = KeyboardType.Text,
    isEnabled: Boolean = true,
    modifier: Modifier = Modifier
) {
    val transformation =
        if (type == KeyboardType.Password) PasswordVisualTransformation() else VisualTransformation.None

    Column(modifier = modifier) {
        TextView(text = label)

        TextField(
            value = input, onValueChange = { onChangeListener(it) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = type),
            singleLine = true,
            maxLines = 1,
            visualTransformation = transformation,
            colors = TextFieldDefaults.textFieldColors(
                textColor = colorResource(id = R.color.black),
                backgroundColor = colorResource(id = R.color.soft_gray),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                disabledTextColor = colorResource(id = R.color.dark_gray)
            ),
            enabled = isEnabled,
            shape = RoundedCornerShape(15.dp)
        )
    }
}