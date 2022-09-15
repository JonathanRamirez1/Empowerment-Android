package com.jonathan.empowerment.di

import android.content.Context
import androidx.room.Room
import com.jonathan.empowerment.data.datasource.local.database.RecipeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object AppModuleTest {

    @Provides
    @Named("test_database")
    fun provideInMemoryDb(@ApplicationContext context: Context) =
        Room.inMemoryDatabaseBuilder(context, RecipeDatabase::class.java)
            .allowMainThreadQueries()
            .build()
}