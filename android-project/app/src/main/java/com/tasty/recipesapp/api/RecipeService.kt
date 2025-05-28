package com.tasty.recipesapp.api



import com.tasty.recipesapp.repository.recipe.model.RecipeDTO
import com.tasty.recipesapp.model.RecipeResponse
import com.tasty.recipesapp.model.SingleRecipeResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface RecipeService {
    @GET("api/recipes")
    suspend fun getRecipes(): List<RecipeDTO>

    @GET("api/recipes/{id}")
    suspend fun getRecipeById(@Path("id") recipeId: Int): RecipeDTO

    @POST("api/recipes")
    suspend fun addRecipe(
        @Header("Authorization") authorization: String,
        @Body recipe: RecipeDTO
    ): RecipeDTO

    @GET("api/recipes/my")
    suspend fun getMyRecipes(
        @Header("Authorization") authorization: String
    ): List<RecipeDTO>

    @DELETE("api/recipes/{id}")
    suspend fun deleteRecipe(
        @Header("Authorization") authorization: String,
        @Path("id") recipeId: Int
    )


}