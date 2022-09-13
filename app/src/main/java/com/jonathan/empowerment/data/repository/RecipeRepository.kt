package com.jonathan.empowerment.data.repository

interface RecipeRepository {

    suspend fun getAllRecipesFromRemote(): List<Recipes>
    suspend fun getAllRecipesFromLocal(): List<Recipes>
    suspend fun insertAllRecipes(items: List<Recipes>)
}