package com.jonathan.empowerment.data.datasource.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jonathan.empowerment.data.datasource.local.dao.RecipeDao
import com.jonathan.empowerment.data.datasource.local.entity.RecipeEntity
import com.jonathan.empowerment.utils.ConvertersRoom

@Database(entities = [RecipeEntity::class], version = 1)
@TypeConverters(ConvertersRoom::class)
abstract class RecipeDatabase : RoomDatabase() {

    abstract fun recipeDao(): RecipeDao
}