package com.jonathan.empowerment.data.datasource.remote.network

import com.jonathan.empowerment.data.datasource.remote.response.RecipeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeApi {

    @GET("{id}/information")
    suspend fun getRecipes(@Path("id") id: Long, @Query("apiKey") apiKey: String): Response<RecipeResponse>
}