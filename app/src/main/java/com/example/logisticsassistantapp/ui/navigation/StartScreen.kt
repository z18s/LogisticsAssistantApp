package com.example.logisticsassistantapp.ui.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.logisticsassistantapp.R
import com.example.logisticsassistantapp.mvvm.viewmodel.MainViewModel
import com.example.logisticsassistantapp.ui.custom.CustomButtonDark
import com.example.logisticsassistantapp.ui.custom.CustomSpacer
import com.example.logisticsassistantapp.ui.custom.CustomSpacerHorizontal
import com.example.logisticsassistantapp.ui.custom.CustomSpacerVertical
import com.example.logisticsassistantapp.ui.custom.CustomTextField
import com.example.logisticsassistantapp.ui.theme.AttentionTextType
import com.example.logisticsassistantapp.ui.theme.BodyTextType
import com.example.logisticsassistantapp.ui.theme.LoginCodeFieldTextType
import com.example.logisticsassistantapp.ui.theme.PhoneNumberFieldSupportTextType
import com.example.logisticsassistantapp.ui.theme.PhoneNumberFieldTextType
import com.example.logisticsassistantapp.ui.theme.StartScreenHeaderTextType
import com.example.logisticsassistantapp.ui.theme.SupportTextType
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun StartScreen(viewModel: MainViewModel = viewModel()) {
    viewModel.onTopBarTabTextChange(stringResource(R.string.start_screen_logo_text))

    val headerText = stringResource(R.string.start_screen_login_phone_header)
    val headerTextState = rememberSaveable(headerText) { mutableStateOf(headerText) }
    val phoneNumber = ""
    val phoneNumberState = rememberSaveable(phoneNumber) { mutableStateOf(phoneNumber) }

    Column(modifier = Modifier.fillMaxSize()) {

        CustomSpacerVertical(CustomSpacer.ExtraLarge)

        Row(verticalAlignment = Alignment.CenterVertically) {
            if (headerTextState.value != headerText) {
                IconButton(
                    onClick = {
                        viewModel.onPhoneNumberReentered()
                        phoneNumberState.value = phoneNumber
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.ic_back_description)
                    )
                }

                CustomSpacerHorizontal(CustomSpacer.ExtraSmall)
            }

            Text(
                text = headerTextState.value,
                style = StartScreenHeaderTextType
            )
        }

        CustomSpacerVertical(CustomSpacer.Small)

        if (viewModel.phoneNumberEntered.observeAsState().value == true) {
            LoginCodeField(viewModel, phoneNumberState)
            headerTextState.value = stringResource(R.string.start_screen_login_code_header)
        } else {
            PhoneNumberField(viewModel, phoneNumberState)
            headerTextState.value = headerText
        }
    }
}

@Composable
fun PhoneNumberField(viewModel: MainViewModel, phoneNumberState: MutableState<String>) {

    Text(
        text = stringResource(R.string.start_screen_login_phone_text),
        style = BodyTextType
    )

    CustomSpacerVertical(CustomSpacer.Medium)

    Column(modifier = Modifier.fillMaxSize()) {
        val phonePrefix = "+7"
        val phonePlaceholder = "9990000000"
        val phoneLength = 10

        CustomTextField(
            value = phoneNumberState.value,
            onValueChange = { number ->
                if (number.length <= phoneLength) phoneNumberState.value = number.filter { it.isDigit() } },
            textStyle = PhoneNumberFieldTextType,
            placeholder = { Text(text = phonePlaceholder, style = PhoneNumberFieldSupportTextType) },
            prefix = { Text(text = phonePrefix, style = PhoneNumberFieldTextType) }
        )

        Spacer(modifier = Modifier.weight(1f))

        CustomButtonDark(
            onClick = { viewModel.onPhoneNumberEntered(phoneNumberState.value) },
            enabled = (phoneNumberState.value.length == phoneLength),
            text = stringResource(R.string.start_screen_login_button)
        )
    }
}

@Composable
fun LoginCodeField(viewModel: MainViewModel, phoneNumber: MutableState<String>) {
    val phoneNumberString = "+7${phoneNumber.value}"

    Text(
        text = stringResource(R.string.start_screen_login_code_text) + phoneNumberString,
        style = BodyTextType
    )

    CustomSpacerVertical(CustomSpacer.Medium)

    Column(modifier = Modifier.fillMaxSize()) {
        val codeLength = 6
        val text = ""
        val loginCodeState = rememberSaveable(text) { mutableStateOf(text) }
        val tick = 59
        val tickState = rememberSaveable(tick) { mutableIntStateOf(tick) }
        val isWrongCode = (viewModel.loginCodeEntered.observeAsState().value == true
                && viewModel.loginCodeChecked.observeAsState().value == false)
        val wrongCodeState = rememberSaveable(isWrongCode) { mutableStateOf(isWrongCode) }

        CustomTextField(
            value = loginCodeState.value,
            onValueChange = { code ->
                if (code.length <= codeLength) loginCodeState.value = code.filter { it.isDigit() } },
            textStyle = LoginCodeFieldTextType,
            label = {
                if (wrongCodeState.value) {
                    Text(
                        text = stringResource(R.string.start_screen_login_code_error),
                        style = BodyTextType
                    )
                    LaunchedEffect(Unit) {
                        delay(3.seconds)
                        viewModel.onLoginCodeReentered()
                    }
                }
            }
        )

        CustomSpacerVertical(CustomSpacer.ExtraSmall)

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            if (tickState.intValue > 0) {
                Text(
                    text = stringResource(R.string.start_screen_login_code_support_text),
                    style =  SupportTextType
                )

                CustomSpacerHorizontal(CustomSpacer.ExtraSmall)

                Timer(tickState)
            } else {
                Text(
                    text = stringResource(R.string.start_screen_login_code_support_text),
                    style =  AttentionTextType,
                    modifier = Modifier.clickable { viewModel.onPhoneNumberEntered(phoneNumber.value); tickState.intValue = 59 }
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        CustomButtonDark(
            onClick = { viewModel.onLoginCodeEntered(loginCodeState.value) },
            enabled = (loginCodeState.value.length == codeLength),
            text = stringResource(R.string.start_screen_login_button)
        )
    }
}

@Composable
fun Timer(tick: MutableIntState) {
    LaunchedEffect(Unit) {
        while(tick.intValue > 0) {
            delay(1.seconds)
            tick.intValue--
        }
    }

    Text(
        text = getTimerValue(tick.intValue),
        style = SupportTextType
    )
}

private fun getTimerValue(num: Int): String = if (num >= 10) "(0:$num)" else "(0:0$num)"

@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    StartScreen()
}