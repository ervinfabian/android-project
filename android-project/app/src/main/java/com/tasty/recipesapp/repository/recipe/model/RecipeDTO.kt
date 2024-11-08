package com.tasty.recipesapp.repository.recipe.model
// a repo a Data access layerbe (DAL) kell lennie
// a repo megy el a sourcehoz ami egy json, kiolvassa az adatot DTO formatumban, a repoban eltarolja, es a repo a UI fele mar csak
// model osztalyokat kuld
data class RecipeDTO(
    val recipeId: Long,
    val name: String,
    val description: String,
    val thumbnailUrl: String,
    val keywords: String,
    val isPublic: Boolean,
    val userEmail: String,
    val originalVideoUrl: String,
    val country: String,
    val numServings: Long,
    val components: List<Any?>,
    val instructions: List<Any?>,
    )

fun RecipeDTO.toModel(): RecipeModel {
    return RecipeModel(
        id = this.recipeId,
        name = this.name,
        description = this.description,
        thumbnailUrl = this.thumbnailUrl,
}