package com.jonathan.empowerment.data.repository

import com.jonathan.empowerment.domain.model.Recipes

interface RecipeRepository {

    suspend fun getAllRecipesFromRemote(): List<Recipes>
    suspend fun getAllRecipesFromLocal(): List<Recipes>
    suspend fun insertAllRecipes(recipes: List<Recipes>)
}