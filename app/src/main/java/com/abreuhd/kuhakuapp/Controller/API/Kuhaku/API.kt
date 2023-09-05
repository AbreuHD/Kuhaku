package com.abreuhd.kuhakuapp.Controller.API.Kuhaku

import android.util.Log
import com.abreuhd.kuhakuapp.Model.Movies.MovieDetail
import com.abreuhd.kuhakuapp.Model.Movies.MoviePreview
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

class API {

    //    suspend fun getMovieList(): Call<MovieList> {
//        val call = getRetrofit().create(APICalls::class.java).getAllMovies()
//        return call
//    }
    suspend fun getMovieList(name: String): List<MoviePreview>? {
        return withContext(Dispatchers.IO) {
            try {
                val response = getRetrofit().create(APICalls::class.java).getAllMovies(name).execute()
                if (response.isSuccessful) {
                    response.body()
                } else {
                    Log.e("nuc", "Request failed with code ${response.code()}")
                    null
                }
            } catch (e: IOException) {
                Log.e("nuc", "Error occurred: ${e}")
                null
            }
        }
    }
    suspend fun getMovieByTMBDID(id: Long): MovieDetail? {
        return withContext(Dispatchers.IO) {
            try {
                val response = getRetrofit().create(APICalls::class.java).getMovieByTMBDID(id).execute()
                if (response.isSuccessful) {
                    response.body()
                } else {
                    Log.e("nuc", "Request failed with code ${response.code()}")
                    null
                }
            } catch (e: IOException) {
                Log.e("nuc", "Error occurred: ${e}")
                null
            }
        }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://abreuhd01-001-site1.itempurl.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(getClient())
            .build()
    }

    private fun getClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HeaderInterceptor())
            .callTimeout(10000, TimeUnit.MILLISECONDS)
            .build()
    }

}