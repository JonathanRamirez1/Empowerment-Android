package com.jonathan.empowerment.ui.view.fragment

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.jonathan.empowerment.databinding.FragmentRecipeBinding
import com.jonathan.empowerment.domain.model.Recipes
import com.jonathan.empowerment.ui.view.adapter.RecipeAdapter
import com.jonathan.empowerment.ui.viewModel.RecipeViewModel
import com.jonathan.empowerment.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RecipeFragment : Fragment() {

    private lateinit var binding: FragmentRecipeBinding
    private lateinit var recipeAdapter: RecipeAdapter

    private val recipeViewModel: RecipeViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentRecipeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecipesAdapter()
        recipeViewModel.onRecipes()
        setObservers()
    }

    private fun setRecipesAdapter() {
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            binding.recyclerViewRecipes.layoutManager = GridLayoutManager(
                requireContext(), 2,
                GridLayoutManager.VERTICAL, false
            )
        } else {
            binding.recyclerViewRecipes.layoutManager = GridLayoutManager(
                requireContext(), 5,
                GridLayoutManager.VERTICAL, false
            )
        }
        recipeAdapter = RecipeAdapter(arrayListOf())
        binding.recyclerViewRecipes.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerViewRecipes.context,
                (binding.recyclerViewRecipes.layoutManager as LinearLayoutManager).orientation
            )
        )

        binding.recyclerViewRecipes.adapter = recipeAdapter
        binding.recyclerViewRecipes.setHasFixedSize(true)
        binding.recyclerViewRecipes.itemAnimator = null


        binding.scrollView.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, _, scrollY, _, _ ->
            if (scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight) {
                binding.progressBar.visibility = View.VISIBLE
            }
        })
    }

    private fun setObservers() {
        recipeViewModel.recipes.observe(viewLifecycleOwner, { recipesResponse ->
            when (recipesResponse.status) {
                Resource.Status.SUCCESS -> {
                    lifecycleScope.launch {
                        binding.progressBar.visibility = View.GONE
                        if (!recipesResponse.data.isNullOrEmpty()) renderList(recipesResponse.data)
                        binding.recyclerViewRecipes.visibility = View.VISIBLE
                    }
                }
                Resource.Status.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), recipesResponse.message, Toast.LENGTH_SHORT)
                        .show()
                }
                Resource.Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.recyclerViewRecipes.visibility = View.GONE
                }
            }
        })
    }

    private fun renderList(data: List<Recipes>) {
        val list = ArrayList<Recipes>()
        list.addAll(data)
        recipeAdapter.submitList(list)
    }
}