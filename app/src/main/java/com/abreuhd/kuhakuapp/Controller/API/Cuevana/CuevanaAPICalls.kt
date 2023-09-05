package com.abreuhd.kuhakuapp.Controller.API.Cuevana

import com.abreuhd.kuhakuapp.Model.Cuevana.CuevanaSkipDataClass
import com.abreuhd.kuhakuapp.Model.Movies.MovieDetail
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface CuevanaAPICalls {
    @POST("/sc/r.php")
    @FormUrlEncoded
    fun getStreamTape(@Field("h") value: String): Call<String>

    @POST("/ir/rd.php")
    fun getStreamTypeOne(@Body cuevanaskipdataclass: CuevanaSkipDataClass): Call<Void>
}