package com.doublebyte.kuhaku.data.kuhakuDTO

data class MoviePreviewDto(
    val id: Long,
    val tmdbid: Long,
    val title: String,
    val adult: Boolean,
    val vote_average: Double,
    val overview: String,
    val poster_path: String,
    val backdrop_path: String? = null,
    val release_date: String
)
