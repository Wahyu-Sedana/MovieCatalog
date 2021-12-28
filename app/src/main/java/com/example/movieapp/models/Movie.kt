package com.example.movieapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
	@SerializedName("results")
	val items: List<MovieResponse>

): Parcelable {
	constructor() : this(mutableListOf())
}
