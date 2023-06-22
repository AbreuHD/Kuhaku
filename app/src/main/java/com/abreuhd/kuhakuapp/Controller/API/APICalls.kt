package com.abreuhd.kuhakuapp.Controller.API

import com.abreuhd.kuhakuapp.Model.Movies.MovieList
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface APICalls {
    @GET("/v1/es/MovieList/GetMovieList")
    fun getAllMovies(): Call<List<MovieList>>
}