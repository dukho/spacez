package com.nomadworks.spacez.common.api.model.launch.link

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Links(
    @Json(name = "patch") val patch: Patch?,
    @Json(name = "flickr") val flickr: Flickr?,
    @Json(name = "presskit") val pressKit: String?,
    @Json(name = "article") val article: String?,
    @Json(name = "youtube_id") val youtubeId: String?
)