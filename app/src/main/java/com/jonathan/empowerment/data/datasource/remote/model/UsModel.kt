package com.jonathan.empowerment.data.datasource.remote.model

import com.google.gson.annotations.SerializedName
import com.jonathan.empowerment.domain.model.Us

data class UsModel(
    @SerializedName("amount") val amount: Long?,
    @SerializedName("unitShort") val unitShort: String?,
    @SerializedName("unitLong") val unitLong: String?
)
fun UsModel.toUs() = Us(
    this.amount,
    this.unitShort,
    this.unitLong
)