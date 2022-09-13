package com.jonathan.empowerment.data.datasource.remote.model

import com.google.gson.annotations.SerializedName

data class RecipeModel(
    @SerializedName("id") val id: Long?,
    @SerializedName("aisle") val aisle: String?,
    @SerializedName("image") val image: String?,
    @SerializedName("consistency") val consistency: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("original") val original: String?,
    @SerializedName("originalName") val originalName: String?,
    @SerializedName("amount") val amount: Float?,
    @SerializedName("measures") val measure: MeasureModel?
)