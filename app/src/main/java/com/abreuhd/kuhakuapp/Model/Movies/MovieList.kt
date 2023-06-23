package com.abreuhd.kuhakuapp.Model.Movies

import com.google.gson.annotations.SerializedName

data class MovieList (
    @SerializedName("adult") val adult: Boolean,
    @SerializedName("backdrop_path") val backdropPath: String,
    //val genreIDS: List<Any?>,
    @SerializedName("id") val id: Long,
    @SerializedName("original_language") val originalLanguage: String,
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("title") val title: String,
    @SerializedName("video") val video: String,
    @SerializedName("vote_average") val voteAverage: Double,
    @SerializedName("vote_count") val voteCount: Long,
    //val cuevana: List<Any?>
)

enum class OriginalLanguage {
    De,
    En,
    Es,
    Pl,
    Vi
}
