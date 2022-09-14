package com.jonathan.empowerment.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jonathan.empowerment.data.datasource.local.entity.MeasureEntity

class ConvertersRoom {

    @TypeConverter
    fun fromGroupTaskMemberOwnerEntity(value: MeasureEntity): String {
        val gson = Gson()
        val type = object : TypeToken<MeasureEntity>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toGroupTaskMemberOwnerEntity(value: String): MeasureEntity {
        val gson = Gson()
        val type = object : TypeToken<MeasureEntity>() {}.type
        return gson.fromJson(value, type)
    }
}