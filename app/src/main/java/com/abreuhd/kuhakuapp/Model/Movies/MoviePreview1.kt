package com.abreuhd.kuhakuapp.Model.Movies

import com.google.gson.annotations.SerializedName

data class MoviePreview(
    @SerializedName("adult") val adult: Boolean,
    @SerializedName("id") val id: Long,
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("title") val title: String,
    @SerializedName("vote_average") val voteAverage: Double
)
