package com.jonathan.empowerment.domain

import com.jonathan.empowerment.data.repository.RecipeRepository
import com.jonathan.empowerment.di.IoDispatcher
import com.jonathan.empowerment.domain.model.Recipes
import com.jonathan.empowerment.utils.InternetCheck
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RecipeUseCase @Inject constructor(
    private val recipeRepository: RecipeRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {

    suspend fun getAllRecipes(): List<Recipes> = withContext(ioDispatcher) {
        val recipesLocal = recipeRepository.getAllRecipesFromLocal()
        if (InternetCheck.isNetworkAvailable() && recipesLocal.isNullOrEmpty()) {
            val recipesRemote = recipeRepository.getAllRecipesFromRemote()
            recipeRepository.insertAllRecipes(recipesRemote)
            recipeRepository.getAllRecipesFromLocal()
        } else {
            recipesLocal
        }
    }
}