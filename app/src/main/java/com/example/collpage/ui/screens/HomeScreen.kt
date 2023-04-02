package com.example.collpage.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.collpage.R
import com.example.collpage.getInputColor
import com.example.collpage.ui.HomeViewModel
import com.example.collpage.ui.User
import com.example.collpage.ui.theme.Poppins
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
    navigateToWelcome: () -> Unit,
    navigateToProfile: () -> Unit,
    navigateToSearch: () -> Unit,
    viewModel: HomeViewModel
) {
    val scaffoldState = rememberScaffoldState()
    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded }
    )
    val scope = rememberCoroutineScope()
    val userData = viewModel.user

    LaunchedEffect(key1 = userData) {
        if (userData == User()) {
            viewModel.getUserData()
        }
    }

    ModalBottomSheetLayout(
        { BottomSheet() }, sheetState = sheetState,
        sheetShape = RoundedCornerShape(20.dp, 20.dp)
    ) {
        Scaffold(
            scaffoldState = scaffoldState,
            floatingActionButton = {
                FloatingActionButton(
                    {
                        scope.launch {
                            if (sheetState.isVisible) sheetState.hide()
                            else sheetState.show()
                        }
                    },
                    Modifier.size(75.dp),
                    backgroundColor = Color(0xFF1C6973)
                ) {
                    Icon(
                        painterResource(R.drawable.logo_button),
                        null,
                        Modifier.size(60.dp),
                        Color(0xFFE5E8CD)
                    )
                }
            },
            isFloatingActionButtonDocked = true,
            floatingActionButtonPosition = FabPosition.Center,
            topBar = {
                HomeTopAppBar {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            },
            bottomBar = { BottomBar(viewModel) },
            drawerContent = { HomeNavDrawer(userData, navigateToWelcome) }
        ) {
            Column(Modifier.padding(it)) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 25.dp, horizontal = 20.dp),
                    Arrangement.Center
                ) {
                    Row(
                        Modifier
                            .width(290.dp)
                            .height(60.dp)
                            .padding(end = 12.dp)
                            .background(
                                getInputColor(), RoundedCornerShape(35.dp)
                            )
                            .clickable { navigateToSearch() }
                    ) {
                        Icon(
                            painterResource(R.drawable.search),
                            null,
                            tint = MaterialTheme.colors.onSurface,
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
                    Image(
                        painterResource(R.drawable.default_profile),
                        null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(60.dp)
                            .clickable { navigateToProfile() }
                    )
                }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 35.dp), Arrangement.SpaceBetween
                ) {
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
                                Modifier.width(195.dp),
                                Color.Black,
                                fontFamily = Poppins,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 23.sp,
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
                Spacer(Modifier.height(20.dp))
                Card(modifier = Modifier.padding(horizontal = 20.dp)) {
                    Column(Modifier.padding(top = 8.dp)) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp),
                            Arrangement.SpaceBetween
                        ) {
                            Row {
                                Image(painterResource(R.drawable.microsoft), null,
                                    Modifier.padding(top = 5.dp))
                                Text(
                                    "Microsoft",
                                    Modifier.padding(start = 5.dp),
                                    fontFamily = Poppins
                                )
                            }
                            Icon(painterResource(R.drawable.bookmark), null)
                        }
                        Text(
                            "We Are Hiring!",
                            Modifier.padding(horizontal = 20.dp),
                            fontFamily = Poppins,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            "For more information : ",
                            Modifier.padding(horizontal = 20.dp).padding(bottom = 10.dp),
                            fontFamily = Poppins,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Image(
                            painterResource(R.drawable.rectangle_2), null,
                        )
                    }
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
                        getInputColor(), RoundedCornerShape(30.dp)
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
                    color = MaterialTheme.colors.onSurface
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

@Composable
fun BottomBar(viewModel: HomeViewModel) {
    viewModel.selectedItem = "Home"
    val homeIcon = if (viewModel.selectedItem == "Home") R.drawable.home_active else R.drawable.home
    val homeIconTint = if (viewModel.selectedItem == "Home") Color(0xFF1C6973)
    else MaterialTheme.colors.onSurface
    BottomAppBar(backgroundColor = MaterialTheme.colors.surface, cutoutShape = CircleShape) {
        BottomNavigationItem(
            viewModel.selectedItem == "Home",
            { viewModel.selectedItem = "Home" },
            { Icon(painterResource(homeIcon), null, tint = homeIconTint) }
        )
        BottomNavigationItem(
            selected = false,
            onClick = {},
            icon = {},
            enabled = false
        )
        BottomNavigationItem(
            selected = viewModel.selectedItem == "Notifications",
            onClick = { viewModel.selectedItem = "Notifications" },
            icon = { Icon(painterResource(R.drawable.notification_bell), null) },
        )
    }
}

@Composable
fun HomeNavDrawer(userData: User, navigateToWelcome: () -> Unit) {
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
        Button(
            onClick = { },
            Modifier.height(60.dp).padding(top = 8.dp),
            shape = RoundedCornerShape(17.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF4E8989))
        ) {
            Icon(painterResource(R.drawable.settings), null, tint = Color.White)
            Text("Pengaturan", fontFamily = Poppins, fontWeight = FontWeight.SemiBold)
        }
    }
}

@Composable
fun BottomSheet() {
    Column(
        Modifier
            .fillMaxHeight()
            .padding(horizontal = 18.dp)) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 17.dp), Arrangement.Center) {
            Divider(
                Modifier
                    .background(color = Color.LightGray, shape = RoundedCornerShape(2.dp))
                    .width(250.dp),
                thickness = 5.dp
            )
        }
        Row(Modifier.fillMaxWidth().padding(top = 20.dp), Arrangement.SpaceBetween) {
            Text(
                "Aktivitas",
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold,
                fontSize = 25.sp
            )
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painterResource(R.drawable.notification_bell), null)
            }
        }
        Surface(
            Modifier
                .height(120.dp)
                .fillMaxWidth(),
            RoundedCornerShape(22.dp),
            Color(0xFFF2B46B)
        ) { }
    }
}