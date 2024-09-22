package com.doublebyte.kuhaku.core.network.kuhakuApi

import com.doublebyte.kuhaku.data.kuhakuDTO.GenericResponseDto
import com.doublebyte.kuhaku.data.kuhakuDTO.HomePageDto
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

interface KuhakuApiCalls {
    @GET("/v1/es/HomeModule/GetHome")
    suspend fun GetHomePageMovies(@Query("kidMode") kidMode: Boolean = false): GenericResponseDto<List<HomePageDto>>
}
