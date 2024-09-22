package com.doublebyte.kuhaku.data.kuhakuDTO

data class HomePageDto(
    val genre: GenreDto,
    val movies: List<MoviePreviewDto?>
)
