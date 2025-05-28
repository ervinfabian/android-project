package com.tasty.recipesapp.repository.recipe

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room
import com.tasty.recipesapp.repository.recipe.model.RecipeEntity

@Database(entities = [RecipeEntity::class], version = 2, exportSchema = false)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao

    companion object {
        @Volatile
        private var INSTANCE: RecipeDatabase? = null

        fun getDatabase(context: Context): RecipeDatabase {
            Log.d("com.tasty.recipeapp", "Getting database instance")
            return INSTANCE ?: synchronized(this) {
                Log.d("com.tasty.recipeapp", "Creating new database instance")
                val instance = Room.databaseBuilder(
                    context.applicationContext,

                    RecipeDatabase::class.java,
                    "recipe_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                Log.d("com.tasty.recipeapp", "Database instance created")
                instance
            }
        }
    }
}