package com.jonathan.empowerment.data.datasource.remote.model

import com.google.gson.annotations.SerializedName
import com.jonathan.empowerment.domain.model.Measure

data class MeasureModel(
    @SerializedName("us") val usModel: UsModel,
    @SerializedName("metric") val metricModel: MetricModel
)

fun MeasureModel.toMeasure() = Measure(
    this.usModel.toUs(),
    this.metricModel.toMetric()
)