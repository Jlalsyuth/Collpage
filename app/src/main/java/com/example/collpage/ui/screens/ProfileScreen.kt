package com.example.collpage.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.collpage.R
import com.example.collpage.ui.*
import com.example.collpage.ui.theme.Poppins

@Composable
fun ProfileScreen(viewModel: HomeViewModel = viewModel()) {
    val user = viewModel.user
    val userProjects = viewModel.userProjects
    val userEducations = viewModel.userEducations
    val userExperiences = viewModel.userExperiences
    val userAchievements = viewModel.userAchievements

    LaunchedEffect(true) {
        if (userProjects.isEmpty() && userEducations.isEmpty()
            && userExperiences.isEmpty() && userAchievements.isEmpty()) {
            viewModel.getUserProjects()
            viewModel.getUserEducations()
            viewModel.getUserExperiences()
            viewModel.getUserAchievements()
        }
    }

    LazyColumn {
        item {
            Box {
                Surface(
                    Modifier
                        .height(110.dp)
                        .fillMaxWidth(), color = Color(0xFF1C6973)
                ) { }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 50.dp, start = 22.dp, end = 5.dp),
                    Arrangement.SpaceBetween
                ) {
                    Image(
                        painterResource(R.drawable.ambatukam),
                        null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(130.dp)
                    )
                    Box(Modifier.padding(top = 65.dp)) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painterResource(R.drawable.edit_icon), null,
                                tint = Color(0xFF1C6973)
                            )
                        }
                    }
                }
            }
        }
        item {
            Column(Modifier.padding(start = 18.dp, top = 10.dp)) {
                Text(
                    user.name,
                    fontFamily = Poppins,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text("@${user.username}", fontFamily = Poppins, fontWeight = FontWeight.Light)
                Text("Intern at PT. Mencari Cinta Sejati", fontFamily = Poppins)
                Text("Malang, Jawa Timur", fontFamily = Poppins, color = Color(0xFF262626))
//            Row {
//
//            }
            }
            Divider(thickness = 1.dp)
        }
        item {
            Column(Modifier.padding(start = 18.dp, top = 10.dp)) {
                Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
                    Text("Tentang", Modifier.padding(top = 4.dp),
                        fontFamily = Poppins, fontWeight = FontWeight.SemiBold)
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painterResource(R.drawable.edit_icon), null,
                            tint = Color(0xFF1C6973)
                        )
                    }
                }
                Text(user.profile_desc, Modifier.padding(end = 22.dp, bottom = 10.dp),
                    fontFamily = Poppins, fontSize = 14.sp)
            }
            Divider(thickness = 1.dp)
        }
        item {
            HeaderSection("Projects")
        }
        items(userProjects) {
            ProjectSection(it)
        }
        item {
            HeaderSection("Pendidikan")
        }
        items(userEducations) {
            EducationSection(it)
        }
        item {
            HeaderSection("Pengalaman")
        }
        items(userExperiences) {
            ExperienceSection(it)
        }
        item {
            HeaderSection("Prestasi")
        }
        items(userAchievements) {
            AchievementSection(it)
        }
    }
}

@Composable
fun ProjectSection(project: Project) {
    Column(Modifier.padding(start = 18.dp, top = 4.dp)) {
        Text(project.name, fontFamily = Poppins, fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
        Text(project.type, Modifier.padding(top = 5.dp), fontFamily = Poppins, fontSize = 14.sp)
        Text("${project.start_date} - ${project.end_date}", fontFamily = Poppins, fontSize = 14.sp)
        Text(
            project.description,
            Modifier.padding(top = 5.dp, bottom = 5.dp, end = 10.dp),
            fontFamily = Poppins, fontSize = 12.sp
        )
        Text("Teman kolaborasi", fontFamily = Poppins, fontSize = 12.sp)
    }
}

@Composable
fun EducationSection(education: Education) {
    Column(Modifier.padding(start = 18.dp, top = 4.dp)) {
        Text(education.name, fontFamily = Poppins, fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
        Text(education.major, Modifier.padding(top = 5.dp), fontFamily = Poppins, fontSize = 14.sp)
        Text("${education.year_in} - ${education.year_out}", fontFamily = Poppins, fontSize = 14.sp)
        education.activities.forEach {
            Text("- $it", Modifier.padding(start = 5.dp), fontFamily = Poppins , fontSize = 14.sp)
        }
    }
}

@Composable
fun ExperienceSection(experience: Experience) {
    val yearOut = if (experience.year_out == 0) "sekarang" else experience.year_out.toString()
    Column(Modifier.padding(start = 18.dp, top = 4.dp)) {
        Text(experience.name, fontFamily = Poppins, fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
        Text(experience.department, Modifier.padding(top = 5.dp), fontFamily = Poppins, fontSize = 14.sp)
        Text("${experience.year_in} - $yearOut", fontFamily = Poppins, fontSize = 14.sp)
        experience.activities.forEach {
            Text("- $it", Modifier.padding(start = 5.dp), fontFamily = Poppins , fontSize = 14.sp)
        }
    }
}

@Composable
fun HeaderSection(title: String) {
    Divider(Modifier.padding(top = 8.dp), thickness = 1.dp)
    Row(
        Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 18.dp), Arrangement.SpaceBetween) {
        Text(title, Modifier.padding(top = 4.dp),
            fontFamily = Poppins, fontWeight = FontWeight.SemiBold)
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painterResource(R.drawable.edit_icon), null,
                tint = Color(0xFF1C6973)
            )
        }
    }
}

@Composable
fun AchievementSection(achievement: Achievement) {
    Column(Modifier.padding(start = 18.dp, top = 4.dp)) {
        Text(achievement.name, fontFamily = Poppins, fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
        Text(achievement.organizer, Modifier.padding(top = 5.dp), fontFamily = Poppins, fontSize = 14.sp)
        Text("Diterbitkan ${achievement.published}", Modifier.padding(top = 5.dp),
            fontFamily = Poppins, fontSize = 14.sp)
    }
}