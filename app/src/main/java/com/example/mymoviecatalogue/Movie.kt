package com.example.mymoviecatalogue

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    var photo: Int,
    var name: String,
    var description: String,
    var genre: String,
    var duration: String,
    var director: String,
    var rating: String
) : Parcelable