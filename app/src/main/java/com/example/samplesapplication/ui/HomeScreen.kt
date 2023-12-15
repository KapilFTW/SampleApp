package com.example.samplesapplication.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.samplesapplication.MainActivity.Companion.PROJECTSCREEN_TAG
import com.example.samplesapplication.MainActivity.Companion.TEMPLATESCREEN_TAG
import com.example.samplesapplication.ui.projectscreen.ProjectScreen
import com.example.samplesapplication.ui.templatescreen.TemplateScreen

@Composable
fun MainApp(){

    val navController = rememberNavController()
     NavHost(navController = navController, startDestination = PROJECTSCREEN_TAG){
         composable(PROJECTSCREEN_TAG){
             ProjectScreen()
         }
         composable(TEMPLATESCREEN_TAG){
             TemplateScreen()
         }
     }

}