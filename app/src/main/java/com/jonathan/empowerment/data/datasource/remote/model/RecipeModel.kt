package com.jonathan.empowerment.data.datasource.remote.model

import com.google.gson.annotations.SerializedName
import com.jonathan.empowerment.domain.model.Recipes

data class RecipeModel(
    @SerializedName("id") val id: Long?,
    @SerializedName("aisle") val aisle: String?,
    @SerializedName("image") val image: String?,
    @SerializedName("consistency") val consistency: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("original") val original: String?,
    @SerializedName("originalName") val originalName: String?,
    @SerializedName("amount") val amount: Float?,
    @SerializedName("measures") val measureModel: MeasureModel?
)

fun RecipeModel.toRecipes() = Recipes(
    this.id,
    this.aisle,
    this.image,
    this.consistency,
    this.name,
    this.original,
    this.originalName,
    this.amount,
    this.measureModel?.toMeasure()
)

fun List<RecipeModel>.toListRecipes() = map { it.toRecipes() }