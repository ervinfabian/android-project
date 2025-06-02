package com.tasty.recipesapp.ui.recipe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tasty.recipesapp.api.ApiRecipeDTO
import com.tasty.recipesapp.databinding.FragmentRecipesBinding
import com.tasty.recipesapp.ui.profile.viewmodel.ProfileViewModel
import com.tasty.recipesapp.ui.recipe.adapter.RecipeListAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

// innen fetchelek es observelek, hogy tortent-e valtozas
//
class RecipesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var adapter: RecipeListAdapter
//    lateinit var list: List<Item>
    private val viewModel: ProfileViewModel by activityViewModels()
    private var _binding: FragmentRecipesBinding? = null
    private val binding get() = _binding!!
    private lateinit var recipeAdapter: RecipeListAdapter
    private var showingMyRecipes = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecipesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeViewModel()
        viewModel.loadRecipes()

    }

    private fun setupRecyclerView() {
        recipeAdapter = RecipeListAdapter(
            onItemClick = { recipe: ApiRecipeDTO ->
                findNavController().navigate(
                    RecipesFragmentDirections.actionRecipesFragmentToRecipeDetailFragment(recipe.recipeID)
                )
            },
            onDeleteClick = { recipe ->
                viewModel.deleteRecipe(recipe.recipeID)
            }
        )
        binding.recyclerView.apply {
            adapter = recipeAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun observeViewModel() {
        viewModel.recipes.observe(viewLifecycleOwner) { recipes ->
            recipeAdapter.updateRecipes(recipes)
        }

        viewModel.error.observe(viewLifecycleOwner) { error ->
            error?.let {
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}