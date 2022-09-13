package com.jonathan.empowerment.data.datasource.remote.model

import com.google.gson.annotations.SerializedName

data class MetricModel(
    @SerializedName("amount") val amount: Long?,
    @SerializedName("unitShort") val unitShort: String?,
    @SerializedName("unitLong") val unitLong: String?
)
