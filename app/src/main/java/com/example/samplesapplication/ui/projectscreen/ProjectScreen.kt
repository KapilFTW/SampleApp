package com.example.samplesapplication.ui.projectscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.R
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.samplesapplication.models.project.UserProject
import com.example.samplesapplication.ui.MainApp
import com.example.samplesapplication.ui.templatescreen.TemplateViewModel
import com.example.samplesapplication.ui.theme.SamplesApplicationTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory

@Composable
fun ProjectScreen(viewModel : ProjectsViewModel = hiltViewModel()) {

    val vm2 : TemplateViewModel = hiltViewModel()
    val projects by viewModel.projects.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "User Projects",
                style = MaterialTheme.typography.headlineSmall
            )
        }
        Divider(thickness = 1.dp)

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
//            projects?.user_projects?.let { this.items(it.size, projects!!.user_projects!!) }
        }
    }
}

@Composable
fun ProjectCard(project: UserProject,onCLick:()-> Unit) {
    Card(
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp, pressedElevation = 2.dp),
        modifier = Modifier.clickable { onCLick() },

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
//            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "",
                modifier = Modifier.padding(8.dp)
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = project.title, style = MaterialTheme.typography.titleMedium)
                Text(text = project.description, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProjectScreen()
}

