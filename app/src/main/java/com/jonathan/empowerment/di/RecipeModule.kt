package com.jonathan.empowerment.di

import com.jonathan.empowerment.data.datasource.local.RecipeLocalDataSource
import com.jonathan.empowerment.data.datasource.local.RecipeLocalDataSourceImpl
import com.jonathan.empowerment.data.datasource.remote.network.RecipeRemoteDataSource
import com.jonathan.empowerment.data.datasource.remote.network.RecipeRemoteDataSourceImpl
import com.jonathan.empowerment.data.repository.RecipeRepository
import com.jonathan.empowerment.data.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RecipeModule {

    @Singleton
    @Provides
    fun provideRemoteDataSource(recipeRemoteDataSourceImpl: RecipeRemoteDataSourceImpl): RecipeRemoteDataSource = recipeRemoteDataSourceImpl

    @Singleton
    @Provides
    fun provideLocalDataSource(recipeLocalDataSourceImpl: RecipeLocalDataSourceImpl): RecipeLocalDataSource = recipeLocalDataSourceImpl

    @Singleton
    @Provides
    fun provideRepository(recipeRepositoryImpl: RecipeRepositoryImpl): RecipeRepository = recipeRepositoryImpl
}