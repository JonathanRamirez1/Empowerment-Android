package com.jonathan.empowerment.data.datasource.local.entity

import com.jonathan.empowerment.domain.model.Us

data class UsEntity(
    val amount: Long?,
    val unitShort: String?,
    val unitLong: String?
)

fun UsEntity.toUs() = Us(
    this.amount,
    this.unitShort,
    this.unitLong
)