package com.doublebyte.kuhaku.data.kuhakuDTO

data class GenericResponseDto<Dto>(
    val payload: Dto,
    val success: Boolean,
    val statuscode: Long,
    val message: Any? = null
)
