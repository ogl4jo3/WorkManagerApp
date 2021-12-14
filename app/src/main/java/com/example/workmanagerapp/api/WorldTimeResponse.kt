package com.example.workmanagerapp.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WorldTimeResponse(
    @field:Json(name = "abbreviation") val abbreviation: String,
    @field:Json(name = "client_ip") val clientIp: String,
    @field:Json(name = "datetime") val datetime: String,
    @field:Json(name = "day_of_week") val dayOfWeek: Int,
    @field:Json(name = "day_of_year") val dayOfYear: Int,
    @field:Json(name = "dst") val dst: Boolean,
    @field:Json(name = "dst_from") val dstFrom: String?,
    @field:Json(name = "dst_offset") val dstOffset: Int,
    @field:Json(name = "dst_until") val dstUntil: String?,
    @field:Json(name = "raw_offset") val rawOffset: Int,
    @field:Json(name = "timezone") val timezone: String,
    @field:Json(name = "unixtime") val unixTime: Int,
    @field:Json(name = "utc_datetime") val utcDatetime: String,
    @field:Json(name = "utc_offset") val utcOffset: String,
    @field:Json(name = "week_number") val weekNumber: Int
)