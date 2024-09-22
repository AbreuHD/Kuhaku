package com.doublebyte.kuhaku.core.network.kuhakuApi

import dagger.Module
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader(
                "Accept", "*/*"
            )
            .addHeader(
                "Authorization",
                ""
            )
            .build()
        return chain.proceed(request)
    }
}