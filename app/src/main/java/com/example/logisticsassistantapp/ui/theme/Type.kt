package com.example.logisticsassistantapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.example.logisticsassistantapp.R

val Typography = Typography(
    bodySmall = TextStyle(
        fontWeight = FontWeight.W400,
        fontFamily = FontFamily(Font(R.font.stolzl_regular)),
        fontSize = 12.sp,
        lineHeight = 14.4.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.W400,
        fontFamily = FontFamily(Font(R.font.stolzl_regular)),
        fontSize = 14.sp,
        lineHeight = 16.8.sp,
        letterSpacing = 0.5.sp
    )
)

val AppBarType = TextStyle(
    color = TextDark,
    fontWeight = FontWeight.W400,
    fontFamily = FontFamily(Font(R.font.stolzl_regular)),
    fontSize = 22.sp,
    lineHeight = 26.4.sp,
    letterSpacing = 0.5.sp
)

val NavigationBarType = TextStyle(
    color = TextDark,
    fontWeight = FontWeight.W400,
    fontFamily = FontFamily(Font(R.font.stolzl_regular)),
    fontSize = 12.sp,
    lineHeight = 16.sp,
    letterSpacing = 0.5.sp
)

val WelcomeTextType = TextStyle(
    color = TextDark,
    fontWeight = FontWeight.W400,
    fontFamily = FontFamily(Font(R.font.stolzl_regular)),
    fontSize = 22.sp,
    lineHeight = 26.4.sp,
    letterSpacing = 0.5.sp
)

val HeaderTextType = TextStyle(
    color = TextDark,
    fontWeight = FontWeight.W400,
    fontFamily = FontFamily(Font(R.font.stolzl_medium)),
    fontSize = 14.sp,
    lineHeight = 16.8.sp,
    letterSpacing = 0.5.sp
)

val SubHeaderTextType = TextStyle(
    color = TextLight,
    fontWeight = FontWeight.W400,
    fontFamily = FontFamily(Font(R.font.stolzl_regular)),
    fontSize = 12.sp,
    lineHeight = 14.4.sp,
    letterSpacing = 0.5.sp
)

val StatusTextType = HeaderTextType.copy(color = TextStatusDone)

val BodyTextType = TextStyle(
    color = TextDark,
    fontWeight = FontWeight.W400,
    fontFamily = FontFamily(Font(R.font.stolzl_book)),
    fontSize = 14.sp,
    lineHeight = 16.8.sp,
    letterSpacing = 0.5.sp
)

val SupportTextType = BodyTextType.copy(color = TextSupport)

val AttentionTextType = BodyTextType.copy(color = TextAttention, textDecoration = TextDecoration.Underline)

val ContactTextType = TextStyle(
    color = TextContact,
    fontWeight = FontWeight.W400,
    fontFamily = FontFamily(Font(R.font.stolzl_medium)),
    fontSize = 12.sp,
    lineHeight = 15.6.sp,
    letterSpacing = 0.5.sp
)

val ButtonTextType = TextStyle(
    color = ButtonText,
    fontWeight = FontWeight.W400,
    fontFamily = FontFamily(Font(R.font.stolzl_regular)),
    fontSize = 14.sp,
    lineHeight = 16.8.sp,
    letterSpacing = 0.5.sp
)

val PhoneNumberFieldTextType = TextStyle(
    color = TextDark,
    fontWeight = FontWeight.W400,
    fontFamily = FontFamily(Font(R.font.stolzl_regular)),
    fontSize = 14.sp,
    lineHeight = 24.sp,
    letterSpacing = 3.sp
)

val PhoneNumberFieldSupportTextType = PhoneNumberFieldTextType.copy(color = TextSupport)

val LoginCodeFieldTextType = PhoneNumberFieldTextType.copy(letterSpacing = 6.sp, textAlign = TextAlign.Center)

val LoginCodeFieldSupportTextType = LoginCodeFieldTextType.copy(color = TextSupport)