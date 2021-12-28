package com.example.movieapp.models

import com.google.gson.annotations.SerializedName

data class Tv(
	@field:SerializedName("results")
	val results: List<TvResponse>
)