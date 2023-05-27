package com.example.jetmixeddogsapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MixedDogs(
    val id: String,
    val name: String,
    val photoUrl: String,
    val description: String,
    val lifeSpan: String,
):Parcelable