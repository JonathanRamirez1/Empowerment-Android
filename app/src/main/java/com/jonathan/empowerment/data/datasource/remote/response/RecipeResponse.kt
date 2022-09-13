package com.jonathan.empowerment.data.datasource.remote.response

import com.google.gson.annotations.SerializedName
import com.jonathan.empowerment.data.datasource.remote.model.RecipeModel

data class RecipeResponse(@SerializedName("extendedIngredients") val result: List<RecipeModel>)