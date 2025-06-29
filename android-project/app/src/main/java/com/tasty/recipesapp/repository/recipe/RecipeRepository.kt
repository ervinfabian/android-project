package com.tasty.recipesapp.repository.recipe

import android.content.Context
import android.util.Log
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.tasty.recipesapp.repository.recipe.model.RecipeDTO
import com.tasty.recipesapp.repository.recipe.model.RecipeModel
import com.tasty.recipesapp.repository.recipe.model.toModel
import java.io.IOException
import com.google.gson.Gson
import com.tasty.recipesapp.api.ApiRecipeDTO
import com.tasty.recipesapp.api.RecipeApiClient

// ebbe kell a gson-os cucc
class RecipeRepository(private val recipeDao: RecipeDao) {
    private val apiClient = RecipeApiClient()
    private val TAG = "RecipeRepository"

    suspend fun getRecipes(): Result<List<ApiRecipeDTO>> = apiClient.getRecipes()

    suspend fun getRecipeById(id: Int): ApiRecipeDTO {
        return apiClient.getRecipeById(id).getOrThrow()
    }


    suspend fun deleteRecipe(recipeId: Int): Result<Unit> {
        return try {
            apiClient.deleteRecipe(recipeId)
        } catch (e: Exception) {
            Log.e("Repository", "Failed to delete recipe", e)
            Result.failure(e)
        }
    }

//    fun getRecipesFromJson(context: Context): List<RecipeModel> {
//        lateinit var jsonString: String
//        try {
//            jsonString =
//                context.assets.open("all_recipes.json")
//                    .bufferedReader()
//                    .use{it.readText()
//                    }
//        }catch (ioException: IOException) {
//            Log.e(TAG, "Error occurred while reading JSON file: $ioException")
//        }
//
//        val type = object : TypeToken<List<RecipeDTO>>() {}.type
//        val recipesDTOList: List<RecipeDTO> = Gson().fromJson(jsonString, type)
//
//        val recipesList = recipesDTOList.toModelList()
//        return recipesList
//    }
//
//
//
//    // list related operations
//}
//
//fun getRecipesFromJson(context: Context): List<RecipeModel> {
//
//    val TAG = "RecipeRepository"
//    lateinit var jsonString: String
//    try {
//        jsonString =
//            context.assets.open("all_recipes.json")
//                .bufferedReader()
//                .use{it.readText()
//                }
//    }catch (ioException: IOException) {
//        Log.e(TAG, "Error occurred while reading JSON file: $ioException")
//    }
//
//    val type = object : TypeToken<List<RecipeDTO>>() {}.type
//    val recipesDTOList: List<RecipeDTO> = Gson().fromJson(jsonString, type)
//
//    val recipesList = recipesDTOList.toModelList()
//    return recipesList
//}

//fun RecipeDTO.toModel(): RecipeModel{
//    return RecipeModel(
//        id = this.recipeId,
//        name = this.name,
//        description = this.description,
//        thumbnailUrl = this.thumbnailUrl)
}
fun List<RecipeDTO>.toModelList(): List<RecipeModel> {
    return this.map { it.toModel() }
}