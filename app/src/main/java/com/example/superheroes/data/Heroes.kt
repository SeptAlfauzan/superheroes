package com.example.superheroes.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Heroes(
    @StringRes val nameId: Int,
    @DrawableRes val imageId: Int,
    @StringRes val abilityId: Int
)
