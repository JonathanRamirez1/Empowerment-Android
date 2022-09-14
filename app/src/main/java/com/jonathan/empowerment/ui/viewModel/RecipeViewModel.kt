package com.jonathan.empowerment.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jonathan.empowerment.domain.RecipeUseCase
import com.jonathan.empowerment.domain.model.Recipes
import com.jonathan.empowerment.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(private val recipeUseCase: RecipeUseCase) : ViewModel() {

    private val _recipes = MutableLiveData<Resource<List<Recipes>>>()
    val recipes: LiveData<Resource<List<Recipes>>> = _recipes

    fun onRecipes() {
        viewModelScope.launch {
            _recipes.postValue(Resource.loading())
            val recipes = recipeUseCase.getAllRecipes()
            if (!recipes.isNullOrEmpty()) {
                _recipes.postValue(Resource.success(recipes))
            } else {
                _recipes.postValue(Resource.error("Sin Internet"))
            }
        }
    }
}