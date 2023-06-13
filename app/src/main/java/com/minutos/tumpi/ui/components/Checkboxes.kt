package com.minutos.tumpi.ui.components

import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.minutos.tumpi.R

@Composable
fun CheckBoxView(
    isChecked: Boolean,
    listener: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true
) {
    Checkbox(
        checked = isChecked,
        onCheckedChange = { listener(it) },
        colors = CheckboxDefaults.colors(
            checkedColor = colorResource(id = R.color.primary_dark),
            checkmarkColor = Color.White,
            uncheckedColor = colorResource(id = R.color.primary_dark),
            disabledColor = colorResource(id = R.color.soft_gray),
            disabledIndeterminateColor = Color.Red
        ),
        enabled = isEnabled,
        modifier = modifier
    )
}