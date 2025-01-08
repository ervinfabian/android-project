package com.tasty.recipesapp.ui.recipe

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.tasty.recipesapp.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RecipesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecipesFragment : Fragment() {
    // TODO: Rename and change types of parameters
//    override fun OnViewCreated(view: View, savedInstanceState: Bundle?) {
//        val viewModel2 = ViewModelProvider(this)[RecipeListViewModel::class.java]
//
//            // Trigger recipes date loading.
//        context?.let {
//            viewModel2.fetchRecipesFromJson(it)
//        }
//        //Subscribe/observe for recipe list changes
//        viewModel2.recipesList.observe(viewLifecycleOwner) {
//            recipes->
//            for ( recipe in recipes ){
//                Log.d("Recipedata", "Recipe ID: $(recipe.id)")
//                Log.d("Recipedata", "Recipe name: $(recipe.name)")
//                Log.d("Recipedata", "Recipe description: $(recipe.description)")
//                Log.d("Recipedata", "Recipe thumbnailUrl: $(recipe.thumbnailUrl)")
//                Log.d("Recipedata", "**********************************************")
//            }
//        }
//
//    }
//
//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment RecipesFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            RecipesFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
}