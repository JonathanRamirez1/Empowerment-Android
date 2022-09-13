package com.jonathan.empowerment.data.datasource.local.entity

import com.jonathan.empowerment.domain.model.Metric
import com.jonathan.empowerment.domain.model.Us

data class MetricEntity(
    val amount: Long?,
    val unitShort: String?,
    val unitLong: String?
)

fun MetricEntity.toMetric() = Metric(
    this.amount,
    this.unitShort,
    this.unitLong
)
