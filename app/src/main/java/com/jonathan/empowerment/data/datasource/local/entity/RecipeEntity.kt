package com.jonathan.empowerment.data.datasource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jonathan.empowerment.data.datasource.remote.model.RecipeModel
import com.jonathan.empowerment.data.datasource.remote.model.toMeasure
import com.jonathan.empowerment.domain.model.Recipes

@Entity(tableName = "recipes_table")
data class RecipeEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long?,
    @ColumnInfo(name = "aisle") val aisle: String?,
    @ColumnInfo(name = "image") val image: String?,
    @ColumnInfo(name = "consistency") val consistency: String?,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "original") val original: String?,
    @ColumnInfo(name = "originalName") val originalName: String?,
    @ColumnInfo(name = "amount") val amount: Float?,
    @ColumnInfo(name = "measures") val measureEntity: MeasureEntity?
)

fun RecipeEntity.toRecipes() = Recipes(
    this.id,
    this.aisle,
    this.image,
    this.consistency,
    this.name,
    this.original,
    this.originalName,
    this.amount,
    this.measureEntity?.toMeasure()
)

fun List<RecipeEntity>.toListRecipes() = map { it.toRecipes() }