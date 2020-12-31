package com.nomadworks.spacez.api.model.launch

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Core(
    @Json(name = "core") val coreId: String?,
    @Json(name = "flight") val flight: Int?,
    @Json(name = "gridfins") val gridFins: Boolean?,
    @Json(name = "legs") val legs: Boolean?,
    @Json(name = "reused") val reused: Boolean?,
    @Json(name = "landing_attempt") val landingAttempt: Boolean?,
    @Json(name = "landing_success") val landingSuccess: Boolean?,
    @Json(name = "landing_type") val landingType: String?,
    @Json(name = "landpad") val landpadId: String?
)