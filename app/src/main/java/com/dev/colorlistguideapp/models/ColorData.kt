package com.dev.colorlistguideapp.models

import com.google.gson.annotations.SerializedName

data class ColorData(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("year") val year: Int,
    @SerializedName("color") val color: String,
    @SerializedName("pantone_value") val pantone_value: String
)

data class ColorResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("per_page") val per_page: Int,
    @SerializedName("total") val total: Int,
    @SerializedName("total_pages") val total_pages: Int,
    @SerializedName("data") val data: List<ColorData>
)

