package com.examen.kotlinmvvm_master.data.model.allproductshop

import com.google.gson.annotations.SerializedName

data class Rating(  @SerializedName("rate"  ) var rate  : Double? = null,
                    @SerializedName("count" ) var count : Int?    = null)
