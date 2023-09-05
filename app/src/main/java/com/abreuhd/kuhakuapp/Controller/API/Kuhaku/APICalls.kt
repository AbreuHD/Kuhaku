package com.abreuhd.kuhakuapp.Controller.API.Kuhaku

import com.abreuhd.kuhakuapp.Model.Movies.MovieDetail
import com.abreuhd.kuhakuapp.Model.Movies.MoviePreview
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APICalls {
    @GET("/v1/es/MovieList/GetMovieList")
    fun getAllMovies(@Query("movieName") movieName: String): Call<List<MoviePreview>>

    @GET("/v1/es/Movie")
    fun getMovieByTMBDID(@Query("tMBDId") tmbdid: Long): Call<MovieDetail>
}
