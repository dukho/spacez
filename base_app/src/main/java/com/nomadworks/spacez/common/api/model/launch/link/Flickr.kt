package com.nomadworks.spacez.common.api.model.launch.link

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Flickr(
    @Json(name = "small") val samll: Array<String>?,
    @Json(name = "original") val original: Array<String>?
)