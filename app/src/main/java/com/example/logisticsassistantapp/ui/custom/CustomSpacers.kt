package com.example.logisticsassistantapp.ui.custom

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.logisticsassistantapp.R

enum class CustomSpacer {
    ExtraSmall,
    Small,
    Medium,
    ExtraLarge
}

@Composable
fun CustomSpacerHorizontal(size: CustomSpacer) {
    Spacer(
        modifier = when (size) {
            CustomSpacer.ExtraSmall -> Modifier.width(dimensionResource(R.dimen.spacer_size_xs))
            CustomSpacer.Small -> Modifier.width(dimensionResource(R.dimen.spacer_size_s))
            CustomSpacer.Medium -> Modifier.width(dimensionResource(R.dimen.spacer_size_m))
            CustomSpacer.ExtraLarge -> Modifier.width(dimensionResource(R.dimen.spacer_size_xl))
        }
    )
}

@Composable
fun CustomSpacerVertical(size: CustomSpacer) {
    Spacer(
        modifier = when (size) {
            CustomSpacer.ExtraSmall -> Modifier.height(dimensionResource(R.dimen.spacer_size_xs))
            CustomSpacer.Small -> Modifier.height(dimensionResource(R.dimen.spacer_size_s))
            CustomSpacer.Medium -> Modifier.height(dimensionResource(R.dimen.spacer_size_m))
            CustomSpacer.ExtraLarge -> Modifier.height(dimensionResource(R.dimen.spacer_size_xl))
        }
    )
}