package com.example.samplesapplication.models.template

data class Rowcolumn(
    val col_id: String,
    val column_data: ColumnData,
    val editableClass: String,
    val field_display_report_order: Any,
    val id: String,
    val isEditableColumn: Boolean,
    val is_filter_field: String,
    val is_report_column: String,
    val old_col_id: Any,
    val old_parent_column_id: Any,
    val parent_column: Any,
    val prt_col_id: String,
    val row_id: String,
    val template_id: String
)