package com.tasty.recipesapp.repository.recipe.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe")
data class RecipeEntity(
    @PrimaryKey(autoGenerate = true)
    val internalId: Long = 0L,
    @ColumnInfo(name = "recipe_id")
    val recipeId: Int,
    @ColumnInfo(name = "json_data")
    val json: String
)
