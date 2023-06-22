package com.abreuhd.kuhakuapp.Controller.API

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
                "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJBYnJldUhEIiwianRpIjoiODFkOWQ1YWQtNTMwMi00N2FkLTkzZTQtZjMxZWZmODUyMjY3IiwiZW1haWwiOiJBYnJ1ZU1hcnRpbmV6SmVmZmVyc29uQGdtYWlsLmNvbSIsInVpZCI6ImQwOTI4M2MyLTg1ZWUtNDA3MS04MmZmLTM0YTRhMmVlY2NkYyIsInJvbGVzIjoiT3duZXIiLCJleHAiOjE2ODc0NzI2NTEsImlzcyI6Ikt1aGFrdSIsImF1ZCI6Ikt1aGFrdUFQSSJ9.WuGCeR5KRhPI55Y6CVJv7jNpgp7ddxdB98cdogIsyPo"
            )
            .build()
        return chain.proceed(request)
    }
}