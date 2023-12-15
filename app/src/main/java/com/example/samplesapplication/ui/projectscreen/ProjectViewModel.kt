package com.example.samplesapplication.ui.projectscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.samplesapplication.models.project.Project
import com.example.samplesapplication.models.project.ProjectData
import com.example.samplesapplication.models.project.UserProject
import com.example.samplesapplication.repository.ProjectsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProjectsViewModel @Inject constructor(private val projectsRepository: ProjectsRepository) :
    ViewModel() {
    private val _projects = MutableStateFlow<ProjectData?>(null)
    val projects = _projects.asStateFlow()

    init {
        fetchProjects()
    }

    private fun fetchProjects() {
        viewModelScope.launch {
//            _projects.update{ projectsRepository.getUserProjects() }
            val data = projectsRepository.getUserProjects()
            Log.i("DATA FETCHED", "$data")
        }
    }

}


