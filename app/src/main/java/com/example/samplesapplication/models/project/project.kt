package com.example.samplesapplication.models.project

data class Project(
    val authToken: String,
    val projectData: ProjectData,
    val datalimit: Any,
    val message: String,
    val success: Boolean
)