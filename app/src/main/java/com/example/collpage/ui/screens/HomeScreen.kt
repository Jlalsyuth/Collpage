package com.example.collpage.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
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
import com.example.collpage.ui.HomeViewModel
import com.example.collpage.ui.theme.Poppins
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(),
    navigateToWelcome: () -> Unit
) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val userData = viewModel.user
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            HomeTopAppBar {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }
        },
        drawerContent = {
            Column(
                Modifier
                    .fillMaxSize()
                    .background(Color(0xFF1C6973))
                    .padding(start = 23.dp, top = 50.dp)
            ) {
                Image(
                    painterResource(R.drawable.default_profile),
                    null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(120.dp)
                )
                Text(
                    "Selamat Datang!", fontFamily = Poppins,
                    fontSize = 23.sp, fontWeight = FontWeight.SemiBold,
                    color = Color(0xFFE5E8CD)
                )
                Text(
                    userData.name, fontFamily = Poppins,
                    fontSize = 23.sp, fontWeight = FontWeight.Medium,
                    color = Color.White
                )
                Button(
                    onClick = {
                        Firebase.auth.signOut()
                        navigateToWelcome()
                    },
                    shape = RoundedCornerShape(17.dp),
                    colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text("Log Out", fontFamily = Poppins, fontWeight = FontWeight.SemiBold)
                }
            }
        }
    ) {
        Column(Modifier.padding(it)) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 35.dp, bottom = 32.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Row(
                    Modifier
                        .width(335.dp)
                        .height(60.dp)
                        .background(
                            Color(0xFFD9D9D9), RoundedCornerShape(35.dp)
                        )
                        .clickable { }
                ) {
                    Icon(
                        painterResource(R.drawable.search),
                        null,
                        tint = Color.Black,
                        modifier = Modifier
                            .padding(top = 12.dp, start = 25.dp)
                            .size(35.dp)
                    )
                    Text(
                        "Search...",
                        fontFamily = Poppins,
                        fontSize = 17.sp,
                        modifier = Modifier.padding(start = 20.dp, top = 16.dp),
                        color = Color(0xFF909090)
                    )
                }
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 35.dp), Arrangement.SpaceBetween) {
                Text(
                    "Berita", fontFamily = Poppins,
                    fontSize = 20.sp, fontWeight = FontWeight.SemiBold,
                )
                IconButton(onClick = { /*TODO*/ }, Modifier.size(20.dp)) {
                    Icon(painterResource(R.drawable.collapse), null)
                }
            }
            Surface(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 35.dp), RoundedCornerShape(25.dp),
                Color(0xFFE5E8CD)
            ) {
                Row(Modifier.padding(start = 24.dp), Arrangement.SpaceBetween) {
                    Column(Modifier.padding(top = 25.dp)) {
                        Text(
                            "Raih Pekerjaan Impianmu",
                            fontFamily = Poppins,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 23.sp,
                            modifier = Modifier.width(195.dp)
                        )
                        Surface(
                            Modifier
                                .width(105.dp)
                                .padding(top = 5.dp, bottom = 10.dp)
                                .clickable { },
                            RoundedCornerShape(15.dp), Color(0xFF1C6973)
                        ) {
                            Text(
                                "Cari Kerja",
                                fontFamily = Poppins,
                                color = Color.White,
                                modifier = Modifier.padding(start = 10.dp)
                            )
                        }
                    }
                    Image(
                        painterResource(R.drawable.image), null,
                        Modifier.padding(top = 8.dp, end = 25.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun HomeTopAppBar(onNavIconClick: () -> Unit) {
    Row(
        Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(Modifier.padding(start = 10.dp, top = 15.dp)) {
            IconButton(onClick = onNavIconClick) {
                Icon(painterResource(R.drawable.nav_drawer), null)
            }
        }
        Row(Modifier.padding(end = 12.dp, top = 20.dp)) {
            Row(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .background(
                        Color(0xFFD9D9D9), RoundedCornerShape(30.dp)
                    )
                    .clickable { }
            ) {
                Icon(
                    painterResource(R.drawable.location),
                    null,
                    tint = Color(0xFF1C6973),
                    modifier = Modifier
                        .size(40.dp)
                        .padding(vertical = 8.dp)
                )
                Text(
                    "Malang",
                    fontFamily = Poppins,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 5.dp, end = 10.dp),
                    fontWeight = FontWeight.Medium,
                    color = Color.Black
                )
                Icon(
                    painterResource(R.drawable.arrow_down),
                    null,
                    Modifier
                        .size(32.dp)
                        .padding(top = 11.dp, end = 12.dp)
                )
            }
        }
    }
}