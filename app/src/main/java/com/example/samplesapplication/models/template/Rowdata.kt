package com.example.samplesapplication.models.template

data class Rowdata(
    val added_by: Int,
    val added_on: String,
    val id: Int,
    val index: Int,
    val isEditableRow: Boolean,
    val is_repeat_data: Boolean,
    val old_row_id: Int,
    val old_stage_id: Int,
    val page: Int,
    val repeat_status: Int,
    val row_order: Int,
    val stage_id: Int,
    val template_id: Int
)