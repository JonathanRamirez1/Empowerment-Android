package com.jonathan.empowerment.domain.model

import com.jonathan.empowerment.data.datasource.local.entity.RecipeEntity

data class Recipes(
    val id: Long?,
    val aisle: String?,
    val image: String?,
    val consistency: String?,
    val name: String?,
    val original: String?,
    val originalName: String?,
    val amount: Float?,
    val measure: Measure?
)

fun Recipes.toRecipeEntity() = RecipeEntity(
    this.id,
    this.aisle,
    this.image,
    this.consistency,
    this.name,
    this.original,
    this.originalName,
    this.amount,
    this.measure?.toMeasureEntity()
)

fun List<Recipes>.toListRecipeEntity() = map { it.toRecipeEntity() }