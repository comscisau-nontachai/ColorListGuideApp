package com.dev.colorlistguideapp.models

import com.google.gson.annotations.SerializedName

data class ColorData(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("year") val year: Int,
    @SerializedName("color") val color: String,
    @SerializedName("pantone_value") val pantone_value: String
)



