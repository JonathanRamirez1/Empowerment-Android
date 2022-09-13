package com.jonathan.empowerment.domain.model

import com.jonathan.empowerment.data.datasource.local.entity.UsEntity

data class Us(
    val amount: Long?,
    val unitShort: String?,
    val unitLong: String?
)

fun Us.toUsEntity() = UsEntity(
    this.amount,
    this.unitShort,
    this.unitLong
)