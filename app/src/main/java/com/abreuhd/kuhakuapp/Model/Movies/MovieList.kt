package com.abreuhd.kuhakuapp.Model.Movies

data class MovieList (
    val adult: Boolean,
    val backdropPath: String,
    //val genreIDS: List<Any?>,
    val id: Long,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: String,
    val voteAverage: Double,
    val voteCount: Long,
    //val cuevana: List<Any?>
)

enum class OriginalLanguage {
    De,
    En,
    Es,
    Pl,
    Vi
}
