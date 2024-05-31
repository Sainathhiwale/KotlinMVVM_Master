package com.examen.kotlinmvvm_master.data.model

data class ValidationResult(
    val successful: Boolean,
    val error: String? = null
)