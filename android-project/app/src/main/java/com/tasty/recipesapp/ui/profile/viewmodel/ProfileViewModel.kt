package com.tasty.recipesapp.ui.profile.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tasty.recipesapp.api.ApiRecipeDTO
import com.tasty.recipesapp.repository.recipe.RecipeDatabase
import com.tasty.recipesapp.repository.recipe.RecipeRepository
import kotlinx.coroutines.launch

class ProfileViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = RecipeDatabase.getDatabase(application).recipeDao()
    private val repository = RecipeRepository(dao)

    private val _recipes = MutableLiveData<List<ApiRecipeDTO>>()
    val recipes: LiveData<List<ApiRecipeDTO>> = _recipes

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    private val _favorites = MutableLiveData<List<ApiRecipeDTO>>()
    val favorites: LiveData<List<ApiRecipeDTO>> = _favorites

    private val _selectedRecipe = MutableLiveData<ApiRecipeDTO>()
    val selectedRecipe: LiveData<ApiRecipeDTO> = _selectedRecipe

    private var showingMyRecipes = false

    init {
        loadRecipes()
    }


    fun loadRecipes() {
        viewModelScope.launch {
            _isLoading.value = true
            repository.getRecipes().fold(
                onSuccess = { recipes ->
                    _recipes.value = recipes
                    _error.value = null
                    Log.d("com.tasty.recipeapp", "Loaded ${recipes.size} recipes")
                },
                onFailure = { e ->
                    _error.value = e.message
                }
            )
            _isLoading.value = false
        }
    }


    fun getRecipeById(id: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val recipe = repository.getRecipeById(id)
                _selectedRecipe.value = recipe
                _error.value = null
            } catch (e: Exception) {
                _error.value = "Failed to load recipe: ${e.message}"
            }
            _isLoading.value = false
        }
    }


    fun deleteRecipe(recipeId: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                repository.deleteRecipe(recipeId)
                // Refresh the list after deletion
                loadRecipes()
            } catch (e: Exception) {
                _error.value = "Failed to delete recipe: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}