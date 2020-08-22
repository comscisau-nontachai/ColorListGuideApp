package com.dev.colorlistguideapp.models

import com.google.gson.annotations.SerializedName

data class ColorResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("per_page") val per_page: Int,
    @SerializedName("total") val total: Int,
    @SerializedName("total_pages") val total_pages: Int,
    @SerializedName("data") val data: MutableList<ColorData>
)