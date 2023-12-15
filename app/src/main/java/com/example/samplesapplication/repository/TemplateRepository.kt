package com.example.samplesapplication.repository

import com.example.samplesapplication.api.ApiService
import com.example.samplesapplication.models.template.TemplateData
import javax.inject.Inject

class TemplateRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getTemplateData(): TemplateData {
        return apiService.getTemplateData()
    }
}