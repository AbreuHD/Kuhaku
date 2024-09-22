package com.doublebyte.kuhaku.core.network.kuhakuApi

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class KuhakuAPIModule {

    @Provides
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.kuhaku.app/")
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

    @Provides
    fun providesKuhakuApisService(retrofit: Retrofit): KuhakuApiCalls {
        return retrofit.create(KuhakuApiCalls::class.java)
    }
}