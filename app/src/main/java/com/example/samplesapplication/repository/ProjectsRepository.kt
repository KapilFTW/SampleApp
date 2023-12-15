package com.example.samplesapplication.repository

import com.example.samplesapplication.api.ApiService
import com.example.samplesapplication.models.project.Project
import com.example.samplesapplication.models.project.ProjectData
import javax.inject.Inject

class ProjectsRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getUserProjects(): Project {
        return apiService.getUserProjects()
    }
}
