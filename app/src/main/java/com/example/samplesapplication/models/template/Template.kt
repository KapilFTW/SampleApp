package com.example.samplesapplication.models.template

data class TempData(
    val authToken: String,
    val `data`: List<TemplateData>,
    val dataHeader: DataHeader,
    val datalimit: Any,
    val isStagedDocument: Boolean,
    val message: String,
    val overdueDates: List<Any>,
    val success: Boolean
)