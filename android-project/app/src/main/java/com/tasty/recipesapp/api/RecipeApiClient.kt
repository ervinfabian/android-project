package com.tasty.recipesapp.api

import android.util.Log
import com.tasty.recipesapp.api.ApiRecipeDTO
import com.tasty.recipesapp.api.RecipeService
//import com.tasty.recipesapp.auth.manager.TokenManager
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RecipeApiClient {
    companion object {
        private const val BASE_URL = "https://recipe-appservice-cthjbdfafnhfdtes.germanywestcentral-01.azurewebsites.net/"
        private const val TAG = "RecipeApiClient"
    }

    private val recipeService: RecipeService by lazy {
        createRecipeService()
    }

    private fun createRecipeService(): RecipeService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RecipeService::class.java)
    }

    suspend fun getRecipes(): Result<List<ApiRecipeDTO>> {
        return try {
            val response = recipeService.getRecipes()
            Log.d(TAG, "Successfully fetched ${response.size} recipes")
            Result.success(response)
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching recipes", e)
            Result.failure(e)
        }
    }

    suspend fun getRecipeById(id: Int): Result<ApiRecipeDTO> {
        return try {
            val response = recipeService.getRecipeById(id)
            Log.d(TAG, "Successfully fetched recipe $id")
            Result.success(response)
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching recipe $id", e)
            Result.failure(e)
        }
    }

    suspend fun deleteRecipe(recipeId: Int): Result<Unit> {
        return try {
            recipeService.deleteRecipe(recipeId)
            Log.d(TAG, "Successfully deleted recipe: $recipeId")
            Result.success(Unit)
        } catch (e: Exception) {
            Log.e(TAG, "Error deleting recipe $recipeId", e)
            Log.e(TAG, "Error message: ${e.message}")
            Result.failure(e)
        }
    }
}