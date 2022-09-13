package com.jonathan.empowerment.data.datasource.local.entity

import com.jonathan.empowerment.domain.model.Measure

data class MeasureEntity(
    val usEntity: UsEntity,
    val metricEntity: MetricEntity
)

fun MeasureEntity.toMeasure() = Measure(
    this.usEntity.toUs(),
    this.metricEntity.toMetric()
)