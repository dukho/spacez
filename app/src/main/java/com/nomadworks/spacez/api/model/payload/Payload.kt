package com.nomadworks.spacez.api.model.payload

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Payload(
    @Json(name = "name") val name: String?,
    @Json(name = "type") val type: String?,
    @Json(name = "reused") val reused: Boolean?,
    @Json(name = "launch") val launchId: String?,
    @Json(name = "customers") val customers: List<String>?,
    @Json(name = "norad_ids") val noradIds: List<String>?,
    @Json(name = "nationalities") val nationalities: List<String>?,
    @Json(name = "manufacturers") val manufacturers: List<String>?,
    @Json(name = "mass_kg") val massKg: Float?,
    @Json(name = "mass_lbs") val massLbs: Float?,
    @Json(name = "orbit") val orbit: String?,
    @Json(name = "reference_system") val referenceSystem: String?,
    @Json(name = "regime") val regime: String?,
    @Json(name = "longitude") val longitude: String?,
    @Json(name = "semi_major_axis_km") val semiMajorAxisKm: Float?,
    @Json(name = "eccentricity") val eccentricity: Float?,
    @Json(name = "periapsis_km") val periapsisKm: Float?,
    @Json(name = "apoapsis_km") val apoapsisKm: Float?,
    @Json(name = "inclination_deg") val inclinationDeg: Float?,
    @Json(name = "period_min") val periodMin: Float?,
    @Json(name = "lifespan_years") val lifespanYears: Int?,
    @Json(name = "epoch") val epoch: String?,
    @Json(name = "mean_motion") val meanMotion: Float?,
    @Json(name = "raan") val raan: Float?,
    @Json(name = "arg_of_pericenter") val argOfPericenter: Float?,
    @Json(name = "mean_anomaly") val mean_anomaly: Float?,
    @Json(name = "id") val id: String?
)