package com.tasty.recipesapp.ui.recipe

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.tasty.recipesapp.R
import com.tasty.recipesapp.ui.recipe.adapter.RecipeListAdapter
import com.tasty.recipesapp.ui.recipe.viewmodel.RecipeListViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

// innen fetchelek es observelek, hogy tortent-e valtozas
//
class RecipesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var adapter: RecipeListAdapter
    lateinit var binding: FragmentListBinding
    lateinit var list: List<Item>
    override fun OnViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel2 = ViewModelProvider(this)[RecipeListViewModel::class.java]
        // Trigger recipes date loading.
        context?.let {
            viewModel2.fetchRecipesFromJson(it)
        }
        //Subscribe/observe for recipe list changes
        viewModel2.recipesList.observe(viewLifecycleOwner) { recipes ->
            for (recipe in recipes) {
                Log.d("Recipedata", "Recipe ID: $(recipe.id)")
                Log.d("Recipedata", "Recipe name: $(recipe.name)")
                Log.d("Recipedata", "Recipe description: $(recipe.description)")
                Log.d("Recipedata", "Recipe thumbnailUrl: $(recipe.thumbnailUrl)")
                Log.d("Recipedata", "**********************************************")
            }
        }
    }
}