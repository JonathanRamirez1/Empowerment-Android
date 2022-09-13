package com.jonathan.empowerment.data.datasource.local

import com.jonathan.empowerment.data.datasource.local.entity.RecipeEntity

class RecipeLocalDataSourceImpl : RecipeLocalDataSource {

    override suspend fun getAllRecipes(): List<RecipeEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun insertAllRecipes(recipes: List<RecipeEntity>) {
        TODO("Not yet implemented")
    }
}