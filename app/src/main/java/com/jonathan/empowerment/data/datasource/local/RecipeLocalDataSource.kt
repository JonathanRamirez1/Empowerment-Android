package com.jonathan.empowerment.data.datasource.local

import com.jonathan.empowerment.data.datasource.local.entity.RecipeEntity

interface RecipeLocalDataSource {

    suspend fun getAllRecipes(): List<RecipeEntity>
    suspend fun insertAllRecipes(recipes: List<RecipeEntity>)
}