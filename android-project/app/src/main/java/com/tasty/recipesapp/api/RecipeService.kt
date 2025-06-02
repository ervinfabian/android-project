package com.tasty.recipesapp.api

import com.tasty.recipesapp.api.ApiRecipeDTO
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface RecipeService {
    @GET("api/recipes")
    suspend fun getRecipes(): List<ApiRecipeDTO>

    @GET("api/recipes/{id}")
    suspend fun getRecipeById(@Path("id") recipeId: Int): ApiRecipeDTO

    @DELETE("api/recipes/{id}")
    suspend fun deleteRecipe(
        @Path("id") recipeId: Int
    )
}