package com.example.harrypotter.data.model


import com.google.gson.annotations.SerializedName

data class WandModel(
    @SerializedName("core")
    val core: String? = "",
    @SerializedName("length")
    val length: Double? = 0.0,
    @SerializedName("wood")
    val wood: String? = ""
)