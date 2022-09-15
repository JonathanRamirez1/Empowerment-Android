package com.jonathan.empowerment.domain

import com.google.common.truth.Truth.assertThat
import com.jonathan.empowerment.data.repository.RecipeRepository
import com.jonathan.empowerment.domain.model.Measure
import com.jonathan.empowerment.domain.model.Metric
import com.jonathan.empowerment.domain.model.Recipes
import com.jonathan.empowerment.domain.model.Us
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class RecipeUseCaseTest {

    @RelaxedMockK
    private lateinit var repository: RecipeRepository

    lateinit var useCase: RecipeUseCase
    lateinit var dispatcher: CoroutineDispatcher

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        dispatcher = Dispatchers.IO
        useCase = RecipeUseCase(repository, dispatcher)
    }

    @Test
    fun `when the api doesn't return anything then get values from database`() = runBlocking {
        coEvery { repository.getAllRecipesFromRemote() } returns emptyList()

        useCase.getAllRecipes()

        coVerify(exactly = 2) { repository.getAllRecipesFromLocal() }
    }

    @Test
    fun `when the api return something then get values from api`() = runBlocking {
        val us = Us(1F, "unitShort", "unitLong")
        val metric = Metric(1F, "unitShort", "unitLong")
        val measure = Measure(us, metric)
        val recipes = listOf(
            Recipes(
                1, "aisle", "image", "consistency",
                "name", "original", "originalName", 1F, measure
            )
        )
        coEvery { repository.getAllRecipesFromRemote() } returns recipes

        val response = useCase.getAllRecipes()

        coVerify { repository.insertAllRecipes(any()) }
        coVerify(exactly = 2) { repository.getAllRecipesFromLocal() }
        assertThat(recipes).doesNotContain(response)
    }
}