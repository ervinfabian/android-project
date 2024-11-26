package com.tasty.recipesapp.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.tasty.recipesapp.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        al factory = ProfileViewModelFactory(activity?.application as App).repostory)
//        viewModel = ViewModelProvider(this, factory)[ProfileViewModel::class.java]
//
//        // get my reipes from memory
//        viewModel.fetchMyRecipesData()
//
//        // Get my recipes from DB
//        // viewModel.getMyRecipesFromDB()
//
//        // Subscirbe/observe for recipe list changes
//        viewModel.myRecipesList.observe(viewLifecycleOwner) { myRecipes ->
//            recipesAdapter.setDAta(myRecipes)
//            // NOtify adapter about the source data change!
//            recipesAdapter.notifyItemRangeChange(0, myRecipes.lastIndex)
//            // recipesAdapter.notifyDataSetChanged()
//            //
    }

    viewModel.deleteResult.observe(viewLifecycleOwner) {
        if (it) {
            Toast.makeText(context, "Recipe removed SUCCESSFULLY", )
        }
    }
}