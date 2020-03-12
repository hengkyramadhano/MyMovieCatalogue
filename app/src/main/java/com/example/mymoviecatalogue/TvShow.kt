package com.example.mymoviecatalogue

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShow(
    var photo: Int,
    var name: String,
    var description: String,
    var genre: String,
    var duration: String,
    var series: String,
    var rating: String
) : Parcelable