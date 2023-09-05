package com.abreuhd.kuhakuapp.Controller.Scraping.VideoSource.WebPages.Cuevana

import android.util.Log
import com.abreuhd.kuhakuapp.Controller.API.Cuevana.CuevanaAPICalls
import com.abreuhd.kuhakuapp.Controller.API.Cuevana.CuevanaHeaderInterceptor
import com.abreuhd.kuhakuapp.Controller.API.Kuhaku.HeaderInterceptor
import com.abreuhd.kuhakuapp.Controller.Scraping.VideoSource.Common.Slmaxed.SlmaxedSkip
import com.abreuhd.kuhakuapp.Controller.Scraping.VideoSource.Common.StreamTape.StreamTapeSkip
import com.abreuhd.kuhakuapp.Model.Cuevana.CuevanaSkipDataClass
import com.google.gson.GsonBuilder
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import org.jsoup.nodes.Document
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class CuevanaSkipFilters() {
    lateinit var webPage: Document

    suspend fun getCuevanaVideoSource(uri: String, serverType: String): String? {
        when{
            serverType.contains("Slmaxed") -> {
                return slmaxedSkip(uri)
            }
            else -> return "no"
        }
    }

    private fun streamTapeSkip(uri: String): String {
        uri.replace("https://apialfa.tomatomatela.club/sc/index.php?h=", "")
        val response = getRetrofit().create(CuevanaAPICalls::class.java).getStreamTape(uri).execute()
        return StreamTapeSkip().Skip(response.headers()["location"].toString())
    }

//    private fun streamSBSkip(uri: String): String{
//        uri.replace("https://apialfa.tomatomatela.club/ir/player.php?h=", "")
//        val response = getRetrofit().create(CuevanaAPICalls::class.java).getStreamTypeOne(uri).execute()
//        return response.headers()["location"].toString()
//    }

    private fun slmaxedSkip(uri: String): String? {
        uri.replace("https://apialfa.tomatomatela.club/ir/player.php?h=", "")
        val payload = CuevanaSkipDataClass(uri)
        val response = getRetrofit().create(CuevanaAPICalls::class.java).getStreamTypeOne(payload).execute()
        Log.i("datainfo", response.headers().toString())
        //val payload = CuevanaSkipDataClass(uri)
        // val data = SlmaxedSkip().Skip("https://apialfa.tomatomatela.club/ir/goto.php?h=$uri")
        return response.headers().toString()
    }
}


private fun getRetrofit(): Retrofit {
    val client = OkHttpClient.Builder()
        .addInterceptor(CuevanaHeaderInterceptor())
        .build()

    val gson = GsonBuilder().setLenient().create()
    return Retrofit.Builder()
        .baseUrl("https://apialfa.tomatomatela.club/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}
