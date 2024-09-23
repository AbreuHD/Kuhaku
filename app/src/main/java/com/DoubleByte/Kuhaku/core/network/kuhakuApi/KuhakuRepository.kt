package com.doublebyte.kuhaku.core.network.kuhakuApi

import com.doublebyte.kuhaku.data.kuhakuDTO.GenericResponseDto
import com.doublebyte.kuhaku.data.kuhakuDTO.HomePageDto
import com.doublebyte.kuhaku.data.kuhakuDTO.MoviePreviewDto
import javax.inject.Inject

class KuhakuRepository @Inject constructor(
    private val kuhakuApiCalls: KuhakuApiCalls
) {
    suspend fun getHomePageMovies(kidMode: Boolean): GenericResponseDto<List<HomePageDto>> {
        return kuhakuApiCalls.GetHomePageMovies(kidMode)
    }

    suspend fun getMovieInfo(Info: String): GenericResponseDto<MoviePreviewDto> {
        return kuhakuApiCalls.GetMovieInfo(Info)
    }
}