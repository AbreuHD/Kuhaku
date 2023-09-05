package com.abreuhd.kuhakuapp.Controller.API.Cuevana

import okhttp3.Interceptor
import okhttp3.Response

class CuevanaHeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Accept", "*/*")
            .addHeader("User-Agent", "Thunder Client (https://www.thunderclient.com)")
            .addHeader("content-type", "multipart/form-data; boundary=---011000010111000001101001")
            .build()
        return chain.proceed(request)
    }
}