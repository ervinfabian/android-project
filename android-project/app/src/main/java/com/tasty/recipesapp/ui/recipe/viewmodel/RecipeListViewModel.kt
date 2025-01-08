package com.tasty.recipesapp.ui.recipe.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tasty.recipesapp.repository.recipe.RecipeRepository
import com.tasty.recipesapp.repository.recipe.model.RecipeModel

class RecipeListViewModel() : ViewModel()  {


    // Live data class member
    var recipesList: MutableLiveData<List<RecipeModel>> = MutableLiveData()
    private val repository: RecipeRepository = RecipeRepository()
    fun fetchRecipesFromJson(context: Context) {
        val recipes = repository.getRecipesFromJson(context)
        recipesList.value = recipes
    }
}
