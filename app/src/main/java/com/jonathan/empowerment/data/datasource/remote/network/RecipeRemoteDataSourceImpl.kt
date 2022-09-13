package com.jonathan.empowerment.data.datasource.remote.network

import com.jonathan.empowerment.data.datasource.remote.model.RecipeModel
import com.jonathan.empowerment.utils.Constants.API_KEY
import com.jonathan.empowerment.utils.Constants.ID_RECIPE
import javax.inject.Inject

class RecipeRemoteDataSourceImpl @Inject constructor(private val recipeApi: RecipeApi) : RecipeRemoteDataSource {

    override suspend fun getRecipesFromApi(): List<RecipeModel> {
        return recipeApi.getRecipes(ID_RECIPE, API_KEY).let { it.body()!!.result }
    }
}