package com.jonathan.empowerment.data.repository

import com.jonathan.empowerment.data.datasource.local.RecipeLocalDataSource
import com.jonathan.empowerment.data.datasource.local.entity.toListRecipes
import com.jonathan.empowerment.data.datasource.remote.model.RecipeModel
import com.jonathan.empowerment.data.datasource.remote.model.toListRecipes
import com.jonathan.empowerment.data.datasource.remote.network.RecipeRemoteDataSource
import com.jonathan.empowerment.domain.model.Recipes
import com.jonathan.empowerment.domain.model.toListRecipeEntity
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val remoteDataSource: RecipeRemoteDataSource,
    private val localDataSource: RecipeLocalDataSource
) : RecipeRepository {

    override suspend fun getAllRecipesFromRemote(): List<Recipes> {
        val response: List<RecipeModel> = remoteDataSource.getRecipesFromApi()
        return response.toListRecipes()
    }

    override suspend fun getAllRecipesFromLocal(): List<Recipes> {
        return localDataSource.getAllRecipes().toListRecipes()
    }

    override suspend fun insertAllRecipes(recipes: List<Recipes>) {
        localDataSource.insertAllRecipes(recipes.toListRecipeEntity())
    }
}