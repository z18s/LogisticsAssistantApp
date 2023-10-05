package com.example.logisticsassistantapp.ui.custom

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import com.example.logisticsassistantapp.R
import com.example.logisticsassistantapp.ui.theme.BodyTextType
import com.example.logisticsassistantapp.ui.theme.TextFieldBorder

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    textStyle: TextStyle = BodyTextType,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    prefix: @Composable (() -> Unit)? = null
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        textStyle = textStyle,
        label = label,
        placeholder = placeholder,
        prefix = prefix,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            autoCorrect = false),
        singleLine = true,
        shape = RoundedCornerShape(dimensionResource(R.dimen.shape_radius)),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = TextFieldBorder,
            unfocusedBorderColor = TextFieldBorder
        )
    )
}