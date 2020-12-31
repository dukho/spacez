package com.nomadworks.spacez.api.model.launch

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Launch(
    @Json(name = "static_fire_date_utc") val staticFireDateUtc: String?,
    @Json(name = "static_fire_date_unix") val staticFireDateUnix: Long?,
    @Json(name = "rocket") val rocketId: String?,
    @Json(name = "details") val details: String?,
    @Json(name = "crew") val crews: List<String>?,
    @Json(name = "ships") val ships: List<String>?,
    @Json(name = "capsules") val capsules: List<String>?,
    @Json(name = "payloads") val payloads: List<String>?,
    @Json(name = "launchpad") val launchpad: String?,
    @Json(name = "flight_number") val flightNumber: String?,
    @Json(name = "name") val name: String?,
    @Json(name = "date_utc") val dateUtc: String?,
    @Json(name = "date_unix") val dateUnix: Long?,
    @Json(name = "cores") val cores: List<Core>?
)