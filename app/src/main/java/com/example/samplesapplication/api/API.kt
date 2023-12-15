package com.example.samplesapplication.api

import com.example.samplesapplication.models.project.Project
import com.example.samplesapplication.models.project.ProjectData
import com.example.samplesapplication.models.template.TempData
import com.example.samplesapplication.models.template.TemplateData
import com.example.samplesapplication.utils.Constants.AUTH_TOKEN
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {
    @GET("mobileapp/getUserAssignedProjects")
    suspend fun getUserProjects(@Header("authToken") authToken: String = AUTH_TOKEN): Project

    @GET("mobileapp/ddoctemplate/2854")
    suspend fun getTemplateData(@Header("authToken") authToken: String = AUTH_TOKEN): TemplateData
}