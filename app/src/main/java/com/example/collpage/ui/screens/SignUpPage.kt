package com.example.collpage.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.collpage.R
import com.example.collpage.ui.AuthViewModel
import com.example.collpage.ui.theme.Poppins

@Composable
fun SignUpPage(
    viewModel: AuthViewModel,
    navigateToNextPage: () -> Unit
) {
    Column {
        Box {
            Image(painterResource(R.drawable.vector_3), null, Modifier.padding(top = 22.dp))
            Image(
                painterResource(R.drawable.vector_6), null
            )
            Column(Modifier.padding(top = 45.dp, start = 35.dp)) {
                Text(
                    "Selamat Datang", fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold, fontSize = 37.sp,
                    color = Color(0xFFE5E8CD)
                )
                Text(
                    "Silahkan buat akun baru!", fontFamily = Poppins,
                    fontWeight = FontWeight.Light, fontSize = 20.sp,
                    color = Color(0xFFE5E8CD)
                )
            }
        }
        Column(Modifier.padding(start = 48.dp, top = 15.dp)) {
            Text("Daftar", fontWeight = FontWeight.Bold, fontSize = 30.sp)
            if (!viewModel.isValidEmail) {
                Text(
                    "Tolong masukkan email yang valid!",
                    color = Color(0xFFE93030),
                    modifier = Modifier.padding(end = 5.dp),
                    fontSize = 12.sp
                )
            }
            OutlinedTextField(
                value = viewModel.username,
                onValueChange = { viewModel.username = it },
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = Color(0xFFD9D9D9),
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color(0xFF1C6973),
                    cursorColor = Color(0xFF1C6973)
                ),
                placeholder = {
                    Text(
                        "Username",
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Light,
                        color = Color(0xFF909090)
                    )
                },
                textStyle = TextStyle(Color.Black),
                modifier = Modifier
                    .width(320.dp)
                    .padding(top = 10.dp)
            )
            Text(
                "*Buatlah Username anda",
                fontFamily = Poppins,
                fontWeight = FontWeight.ExtraLight,
                fontSize = 13.sp,
                modifier = Modifier.padding(bottom = 14.dp)
            )
            OutlinedTextField(
                value = viewModel.email,
                onValueChange = { viewModel.email = it },
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = Color(0xFFD9D9D9),
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color(0xFF1C6973),
                    cursorColor = Color(0xFF1C6973)
                ),
                placeholder = {
                    Text(
                        "E-mail",
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Light,
                        color = Color(0xFF909090)
                    )
                },
                textStyle = TextStyle(Color.Black),
                modifier = Modifier
                    .width(320.dp)
                    .padding(top = 10.dp)
            )
            Text(
                "*Masukkan alamat E-mail anda",
                fontFamily = Poppins,
                fontWeight = FontWeight.ExtraLight,
                fontSize = 13.sp,
                modifier = Modifier.padding(bottom = 14.dp)
            )
            Button(
                onClick = {
                    viewModel.handleEmailInput()
                    if (viewModel.isValidEmail) {
                        navigateToNextPage()
                    }
                },
                enabled = viewModel.username.text != "" && viewModel.email.text != "",
                shape = RoundedCornerShape(25.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF1C6973)),
                modifier = Modifier.width(330.dp).padding(end = 18.dp, top = 15.dp)
            ) {
                Text(
                    "Selanjutnya",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 5.dp)
                )
            }
        }
    }
}