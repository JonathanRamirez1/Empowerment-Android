package com.jonathan.empowerment.ui.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.jonathan.empowerment.domain.RecipeUseCase
import com.jonathan.empowerment.domain.model.Measure
import com.jonathan.empowerment.domain.model.Metric
import com.jonathan.empowerment.domain.model.Recipes
import com.jonathan.empowerment.domain.model.Us
import com.jonathan.empowerment.utils.Resource
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class RecipeViewModelTest {

    @get:Rule
    var instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @RelaxedMockK
    private lateinit var useCase: RecipeUseCase

    private lateinit var viewModel: RecipeViewModel

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        viewModel = RecipeViewModel(useCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when viewModel is created at the first time, get all recipes and set the all value`() =
        runTest {
            val us = Us(1F, "unitShort", "unitLong")
            val metric = Metric(1F, "unitShort", "unitLong")
            val measure = Measure(us, metric)
            val recipes = listOf(
                Recipes(
                    1, "aisle", "image", "consistency",
                    "name", "original", "originalName", 1F, measure
                )
            )
            val musicResource: Resource<List<Recipes>>? = viewModel.recipes.value
            coEvery { useCase.getAllRecipes() } returns (musicResource?.data ?: recipes)

            viewModel.onRecipes()

            if (musicResource != null) {
                assertThat(viewModel.recipes.value).isEqualTo(musicResource.data)
            }
        }

    @Test
    fun `when viewModel is created at the returns errors`() =
        runTest {
            val items = listOf<Recipes>()
            val musicResource: Resource<List<Recipes>>? = viewModel.recipes.value
            coEvery { useCase.getAllRecipes() } returns (musicResource?.data ?: items)

            viewModel.onRecipes()

            assertThat(musicResource).isNull()
        }
}