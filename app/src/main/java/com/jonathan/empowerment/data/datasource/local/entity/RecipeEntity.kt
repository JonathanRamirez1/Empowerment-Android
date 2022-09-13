package com.jonathan.empowerment.data.datasource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

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