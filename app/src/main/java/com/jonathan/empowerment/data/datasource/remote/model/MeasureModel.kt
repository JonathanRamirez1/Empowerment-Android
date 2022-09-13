package com.jonathan.empowerment.data.datasource.remote.model

import com.google.gson.annotations.SerializedName

data class MeasureModel(
    @SerializedName("us") val usModel: UsModel,
    @SerializedName("metric") val metricModel: MetricModel
)