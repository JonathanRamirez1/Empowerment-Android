package com.jonathan.empowerment.data.datasource.remote.network

import com.jonathan.empowerment.data.datasource.remote.model.RecipeModel

interface RecipeRemoteDataSource {

    suspend fun getRecipesFromApi(): List<RecipeModel>
}