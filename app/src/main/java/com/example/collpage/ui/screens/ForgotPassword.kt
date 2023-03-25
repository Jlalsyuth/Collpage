package com.example.collpage.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ForgotPassword(
    viewModel: AuthViewModel = viewModel(),
    navigateToEmailCheck: () -> Unit
) {
    val textFieldPadding = if (!viewModel.isValidEmail) 12.dp else 30.dp
    Column {
        Box {
            Image(painterResource(R.drawable.vector_3), null, Modifier.padding(top = 22.dp))
            Image(
                painterResource(R.drawable.vector_6), null
            )
            Column(Modifier.padding(top = 45.dp, start = 35.dp)) {
                Text(
                    "Lupa Password?", fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold, fontSize = 37.sp,
                    color = Color(0xFFE5E8CD)
                )
                Text(
                    "Masukkan Email anda yang terdaftar pada Collpage!", fontFamily = Poppins,
                    fontWeight = FontWeight.Light, fontSize = 20.sp,
                    color = Color(0xFFE5E8CD)
                )
            }
        }
        if (!viewModel.isValidEmail) {
            Text(
                "Tolong masukkan email yang valid!",
                color = Color(0xFFE93030),
                modifier = Modifier.padding(start = 50.dp, top = 15.dp),
                fontSize = 12.sp
            )
        }
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
                    "Email",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Light,
                    color = Color(0xFF909090)
                )
            },
            textStyle = TextStyle(Color.Black),
            modifier = Modifier
                .width(360.dp)
                .padding(top = textFieldPadding, start = 50.dp)
        )
        Row(Modifier.fillMaxWidth(), Arrangement.End) {
            Button(
                onClick = {
                    viewModel.handleEmailInput()
                    if (viewModel.isValidEmail) {
                        viewModel.sendPassResetEmail()
                        navigateToEmailCheck()
                    }
                },
                enabled = viewModel.email.text != "",
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF1C6973)),
                modifier = Modifier
                    .width(190.dp)
                    .padding(end = 50.dp, top = 25.dp)
            ) {
                Text(
                    "Kirim",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    color = Color.White,
                )
            }
        }
    }
}