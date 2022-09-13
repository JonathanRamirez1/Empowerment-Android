package com.jonathan.empowerment.data.datasource.remote.network

import com.jonathan.empowerment.data.datasource.remote.model.RecipeModel

class RecipeRemoteDataSourceImpl : RecipeRemoteDataSource {

    override suspend fun getRecipesFromApi(): List<RecipeModel> {
        TODO("Not yet implemented")
    }
}