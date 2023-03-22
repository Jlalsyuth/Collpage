package com.example.collpage.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.collpage.R
import com.example.collpage.data.OnboardingData
import com.example.collpage.ui.WelcomeViewModel
import com.example.collpage.ui.navigation.Screen
import com.example.collpage.ui.theme.Poppins
import com.google.accompanist.pager.*

@OptIn(ExperimentalPagerApi::class)
@Composable
fun WelcomePage(viewModel: WelcomeViewModel = viewModel(), navController: NavHostController, ) {
    val pagerState = rememberPagerState()
    OnboardingPager(viewModel.onboardingItems, pagerState, navController = navController)
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingPager(
    item: List<OnboardingData>,
    pagerState: PagerState,
    navController: NavHostController,
) {
    Column(
        Modifier
            .background(Color(0xFFE5E8CD))
            .fillMaxSize()
    ) {
        HorizontalPager(state = pagerState, count = 3, modifier = Modifier.weight(1f)) { page ->
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxHeight()
            ) {
                Image(
                    painterResource(item[page].imageId),
                    null,
                    Modifier
                        .size(350.dp)
                        .padding(top = 25.dp)
                )
            }
        }
        Column(
            Modifier
                .weight(1.2f)
                .padding(start = 20.dp)
        ) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    item[pagerState.currentPage].shortDesc,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF1C6973),
                    fontSize = 20.sp
                )
                HorizontalPagerIndicator(
                    pagerState,
                    Modifier.padding(end = 110.dp, top = 15.dp),
                    activeColor = Color(0xFF1C6973),
                    inactiveColor = Color(0xFF80A89F)
                )
            }
            Box(Modifier.padding(top = 22.dp)) {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    Image(
                        painterResource(R.drawable.arrow_icon),
                        null,
                        Modifier
                            .height(200.dp)
                            .padding(top = 10.dp)
                    )
                }
                Text(
                    item[pagerState.currentPage].longDesc,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    fontSize = 35.sp,
                    modifier = Modifier.width(270.dp)
                )
            }
            if (item[pagerState.currentPage].isLastPage) {
                Button(
                    onClick = { navController.navigate(Screen.Login.route) },
                    shape = RoundedCornerShape(15.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFF1C6973)),
                    modifier = Modifier.padding(top = 7.dp)
                ) {
                    Text(
                        "Get Started",
                        fontFamily = Poppins,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp,
                        color = Color.White
                    )
                }
            } else {
                ClickableText(
                    text = AnnotatedString("Lewati"),
                    onClick = { navController.navigate(Screen.Login.route) },
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp,
                        color = Color(0xFF1C6973)
                    )
                )
            }
        }
    }
}