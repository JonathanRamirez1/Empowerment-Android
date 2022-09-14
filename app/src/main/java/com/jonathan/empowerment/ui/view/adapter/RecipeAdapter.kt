package com.jonathan.empowerment.ui.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.imageLoader
import coil.request.ImageRequest
import com.jonathan.empowerment.R
import com.jonathan.empowerment.databinding.ItemRecipesBinding
import com.jonathan.empowerment.domain.model.Recipes
import com.jonathan.empowerment.utils.Constants.BASE_IMAGE_URL

class RecipeAdapter(private val itemRecipes: ArrayList<Recipes>) :
    RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    private lateinit var context: Context
    private lateinit var navController: NavController

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeAdapter.RecipeViewHolder {
        context = parent.context
        return RecipeViewHolder(
            ItemRecipesBinding.inflate(
                LayoutInflater.from(context)
            )
        )
    }

    override fun onBindViewHolder(holder: RecipeAdapter.RecipeViewHolder, position: Int) {
        holder.bind(itemRecipes[position], context)
        holder.itemView.setOnClickListener { view ->
            val result = itemRecipes[position]

            navController = Navigation.findNavController(view)
            navController.navigate(
                R.id.recipeDetailFragment,
                bundleOf(
                    "name" to result.name
                )
            )
        }
    }

    override fun getItemCount(): Int = itemRecipes.size

    fun submitList(itemList: ArrayList<Recipes>) {
        this.itemRecipes.clear()
        this.itemRecipes.addAll(itemList)
        notifyItemInserted(itemRecipes.size - 1)
    }

    inner class RecipeViewHolder(private val binding: ItemRecipesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(recipes: Recipes, context: Context) {
            val imageRequest = ImageRequest.Builder(context)
                .data("$BASE_IMAGE_URL${recipes.image}")
                .crossfade(true)
                .size(1280, 720)
                .target(
                    onStart = {
                        binding.imageViewRecipes.setImageResource(R.drawable.ic_access_time)
                    },
                    onSuccess = { avatar ->
                        binding.progressBar.visibility = View.GONE
                        binding.imageViewRecipes.scaleType = ImageView.ScaleType.CENTER_CROP
                        binding.imageViewRecipes.setImageDrawable(avatar)
                    },
                    onError = {
                        binding.progressBar.visibility = View.GONE
                        binding.imageViewRecipes.setImageResource(R.drawable.ic_load_error)
                    }
                )
                .build()
            context.imageLoader.enqueue(imageRequest)
            binding.textViewName.text = recipes.name
        }
    }
}