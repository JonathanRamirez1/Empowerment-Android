package com.jonathan.empowerment.data.datasource.remote.model

import com.google.gson.annotations.SerializedName
import com.jonathan.empowerment.domain.model.Metric
import com.jonathan.empowerment.domain.model.Us

data class MetricModel(
    @SerializedName("amount") val amount: Long?,
    @SerializedName("unitShort") val unitShort: String?,
    @SerializedName("unitLong") val unitLong: String?
)

fun MetricModel.toMetric() = Metric(
    this.amount,
    this.unitShort,
    this.unitLong
)
