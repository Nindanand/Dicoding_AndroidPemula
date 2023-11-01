package com.example.submission

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Anime(
    val rilis: String,
    val name: String,
    val genre: String,
    val photo: Int,
    val sutradara: String,
    val sinopsis: String
) : Parcelable