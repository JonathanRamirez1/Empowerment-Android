package com.jonathan.empowerment.data.datasource.local.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.jonathan.empowerment.data.datasource.local.database.RecipeDatabase
import com.jonathan.empowerment.data.datasource.local.entity.MeasureEntity
import com.jonathan.empowerment.data.datasource.local.entity.MetricEntity
import com.jonathan.empowerment.data.datasource.local.entity.RecipeEntity
import com.jonathan.empowerment.data.datasource.local.entity.UsEntity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named

@ExperimentalCoroutinesApi
@SmallTest
@HiltAndroidTest
class RecipeDaoTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    @Named("test_database")
    lateinit var database: RecipeDatabase
    lateinit var dao: RecipeDao

    @Before
    fun setup() {
        hiltRule.inject()
        dao = database.recipeDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun insertAllItems() = runTest {
        val usEntity = UsEntity(1F, "unitShort", "unitLong")
        val metricEntity = MetricEntity(1F, "unitShort", "unitLong")
        val measureEntity = MeasureEntity(usEntity, metricEntity)
        val recipesEntity = RecipeEntity(1, "aisle", "image", "consistency",
        "name", "original", "originalName", 1F, measureEntity)
        val recipes: List<RecipeEntity> = listOf(recipesEntity)
        dao.insertAllRecipes(recipes)

        val allRecipes = dao.getAllRecipes()
        assertThat(allRecipes).contains(recipesEntity)
    }

    @Test
    fun getAllItems() = runTest {
        val usEntity = UsEntity(1F, "unitShort", "unitLong")
        val metricEntity = MetricEntity(1F, "unitShort", "unitLong")
        val measureEntity = MeasureEntity(usEntity, metricEntity)
        val recipesEntity = RecipeEntity(1, "aisle", "image", "consistency",
            "name", "original", "originalName", 1F, measureEntity)
        val recipes: List<RecipeEntity> = listOf(recipesEntity)
        dao.insertAllRecipes(recipes)

        val allRecipes = dao.getAllRecipes()
        assertThat(allRecipes).isNotEmpty()
    }
}