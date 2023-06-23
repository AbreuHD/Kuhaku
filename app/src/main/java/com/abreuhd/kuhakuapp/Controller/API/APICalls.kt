package com.abreuhd.kuhakuapp.Controller.API

import com.abreuhd.kuhakuapp.Model.Movies.MovieList
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APICalls {
    @GET("/v1/es/MovieList/GetMovieList")
    fun getAllMovies(@Query("movieName") movieName: String): Call<List<MovieList>>

    @GET("/v1/es/Movie")
    fun getMovieByTMBDID(@Query("tMBDId") tmbdid: Long): Call<MovieList>
}
