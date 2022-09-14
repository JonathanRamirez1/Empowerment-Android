package com.jonathan.empowerment.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.jonathan.empowerment.R
import com.jonathan.empowerment.databinding.FragmentRecipeDetailBinding
import com.jonathan.empowerment.utils.Constants

class RecipeDetailFragment : Fragment() {

    private lateinit var binding: FragmentRecipeDetailBinding
    private lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentRecipeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        launchRecipeFragment(view)
        setContent()
    }

    private fun launchRecipeFragment(view: View) {
        navController = Navigation.findNavController(view)
        binding.imageViewBack.setOnClickListener {
            navController.navigate(R.id.recipeFragment)
        }
    }

    private fun setContent() {
        arguments?.let { bundle ->
            binding.apply {
                textViewAisle.text = bundle.getString("aisle")
                Glide.with(requireContext())
                    .load("${Constants.BASE_IMAGE_URL}${bundle.getString("image")}")
                    .centerCrop()
                    .into(imageViewRecipe)
                textViewConsistency.text = bundle.getString("consistency")
                textViewOriginal.text = bundle.getString("original")
                textViewOriginalName.text = bundle.getString("originalName")
                textViewAmount.text = bundle.getFloat("amount").toString()
                textViewUsAmount.text = bundle.getFloat("usAmount").toString()
                textViewUsUnitShort.text = bundle.getString("usShort")
                textViewUsUnitLong.text = bundle.getString("usLong")
                textViewMetricAmount.text = bundle.getFloat("metricAmount").toString()
                textViewMetricUnitShort.text = bundle.getString("metricShort")
                textViewMetricUnitLong.text = bundle.getString("metricLong")
            }
        }
    }
}