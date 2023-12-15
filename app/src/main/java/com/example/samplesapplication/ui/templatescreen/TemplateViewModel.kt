package com.example.samplesapplication.ui.templatescreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.samplesapplication.models.template.TemplateData
import com.example.samplesapplication.repository.ProjectsRepository
import com.example.samplesapplication.repository.TemplateRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TemplateViewModel @Inject constructor(private val repository: TemplateRepository): ViewModel(){

    private val _template = MutableStateFlow<TemplateData?>(null)
    val template = _template.asStateFlow()
    init {
        fetchTemplates()
    }

    private fun fetchTemplates(){
        viewModelScope.launch{
            _template.update { repository.getTemplateData() }
            Log.i("TEMPLATE FETCH",template.value.toString())
        }
    }
}