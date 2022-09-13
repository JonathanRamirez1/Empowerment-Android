package com.jonathan.empowerment.domain.model

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