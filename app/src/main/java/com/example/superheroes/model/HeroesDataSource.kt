package com.example.superheroes.model

import com.example.superheroes.R
import com.example.superheroes.data.Heroes

object HeroesRepository {
    val heroes: List<Heroes> = listOf<Heroes>(
        Heroes(
            nameId = R.string.superheroes1,
            abilityId = R.string.description1,
            imageId = R.drawable.android_superhero1
        ),
        Heroes(
            nameId = R.string.superheroes2,
            abilityId = R.string.description2,
            imageId = R.drawable.android_superhero2
        ),
        Heroes(
            nameId = R.string.superheroes3,
            abilityId = R.string.description3,
            imageId = R.drawable.android_superhero3
        ),
        Heroes(
            nameId = R.string.superheroes4,
            abilityId = R.string.description4,
            imageId = R.drawable.android_superhero4
        ),
        Heroes(
            nameId = R.string.superheroes5,
            abilityId = R.string.description5,
            imageId = R.drawable.android_superhero5
        ),
        Heroes(
            nameId = R.string.superheroes6,
            abilityId = R.string.description6,
            imageId = R.drawable.android_superhero6
        ),
    )
}