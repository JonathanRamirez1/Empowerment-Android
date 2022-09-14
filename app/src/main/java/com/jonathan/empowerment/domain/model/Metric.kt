package com.jonathan.empowerment.domain.model

import com.jonathan.empowerment.data.datasource.local.entity.MetricEntity

data class Metric(
    val amount: Float?,
    val unitShort: String?,
    val unitLong: String?
)

fun Metric.toMetricEntity() = MetricEntity(
    this.amount,
    this.unitShort,
    this.unitLong
)
