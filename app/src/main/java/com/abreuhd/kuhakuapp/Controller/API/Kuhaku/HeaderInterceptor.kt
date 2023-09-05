package com.abreuhd.kuhakuapp.Controller.API.Kuhaku

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