package com.jonathan.empowerment.domain.model

import com.jonathan.empowerment.data.datasource.local.entity.MeasureEntity

data class Measure(
    val us: Us,
    val metric: Metric
)

fun Measure.toMeasureEntity() = MeasureEntity(
    this.us.toUsEntity(),
    this.metric.toMetricEntity()
)