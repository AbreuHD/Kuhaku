package com.abreuhd.kuhakuapp.Model.Movies

import com.google.gson.annotations.SerializedName

data class MovieDetail (
    @SerializedName("adult") val adult: Boolean,
    @SerializedName("id") val id: Long,
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("title") val title: String,
    @SerializedName("vote_average") val voteAverage: Double,
    @SerializedName("movieLinks") val movieLinks: List<MovieLink>
)
data class MovieLink (
    val title: String,
    val photo: String,
    val link: String,
    val age: String,
    val confirmed: Boolean,
    val tmdbID: String
)