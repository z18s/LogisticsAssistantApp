package com.example.logisticsassistantapp.ui.custom

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.logisticsassistantapp.R
import com.example.logisticsassistantapp.ui.theme.ButtonDarkBackground
import com.example.logisticsassistantapp.ui.theme.ButtonDarkDisabledBackground
import com.example.logisticsassistantapp.ui.theme.ButtonLightBackground
import com.example.logisticsassistantapp.ui.theme.ButtonLightDisabledBackground
import com.example.logisticsassistantapp.ui.theme.ButtonMediumBackground
import com.example.logisticsassistantapp.ui.theme.ButtonMediumDisabledBackground
import com.example.logisticsassistantapp.ui.theme.ButtonTextType
import com.example.logisticsassistantapp.ui.theme.TextDark
import com.example.logisticsassistantapp.ui.theme.TextExtraLight
import com.example.logisticsassistantapp.ui.theme.TextSupport

@Composable
fun CustomButton(
    onClick: () -> Unit,
    enabled: Boolean,
    colors: ButtonColors,
    text: String
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(dimensionResource(R.dimen.shape_radius)),
        colors = colors,
        modifier = Modifier
            .height(dimensionResource(R.dimen.button_height))
            .fillMaxWidth()
    ) {
        Text(
            text = text,
            style = ButtonTextType
        )
    }
}

@Composable
fun CustomButtonLight(
    onClick: () -> Unit,
    enabled: Boolean = true,
    text: String = ""
) {
    CustomButton(
        onClick = onClick,
        enabled = enabled,
        colors =  ButtonDefaults.buttonColors(
            containerColor = ButtonLightBackground,
            contentColor = TextDark,
            disabledContainerColor = ButtonLightDisabledBackground,
            disabledContentColor = TextSupport
        ),
        text = text
    )
}

@Composable
fun CustomButtonMedium(
    onClick: () -> Unit,
    enabled: Boolean = true,
    text: String = ""
) {
    CustomButton(
        onClick = onClick,
        enabled = enabled,
        colors =  ButtonDefaults.buttonColors(
            containerColor = ButtonMediumBackground,
            contentColor = TextDark,
            disabledContainerColor = ButtonMediumDisabledBackground,
            disabledContentColor = TextSupport
        ),
        text = text
    )
}

@Composable
fun CustomButtonDark(
    onClick: () -> Unit,
    enabled: Boolean = true,
    text: String = ""
) {
    CustomButton(
        onClick = onClick,
        enabled = enabled,
        colors =  ButtonDefaults.buttonColors(
            containerColor = ButtonDarkBackground,
            contentColor = TextExtraLight,
            disabledContainerColor = ButtonDarkDisabledBackground,
            disabledContentColor = TextSupport
        ),
        text = text
    )
}