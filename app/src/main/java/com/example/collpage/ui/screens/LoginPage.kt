package com.example.collpage.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.collpage.R
import com.example.collpage.ui.AuthViewModel
import com.example.collpage.ui.theme.Poppins

@Composable
fun LoginPage(viewModel: AuthViewModel = viewModel(), navigateToSignUp: (Int) -> Unit) {
    val rememberMeIcon = if (viewModel.rememberMe) R.drawable.vector_2 else R.drawable.vector
    val tint = if (viewModel.rememberMe) Color(0xFF1C6973) else Color(0xFF909090)
    val passwordIconRes = if (viewModel.isPasswordVisible) R.drawable.mdi_eye_on
    else R.drawable.mdi_eye_off
    val visualTransformation = if (viewModel.isPasswordVisible) VisualTransformation.None
    else PasswordVisualTransformation()
    val passwordIcon = @Composable {
        IconButton(
            onClick = { viewModel.isPasswordVisible = !viewModel.isPasswordVisible },
            Modifier.size(34.dp)
        ) {
            Icon(painterResource(passwordIconRes), null)
        }
    }

    Column {
        Box {
            Image(painterResource(R.drawable.vector_6), null, Modifier.padding(top = 22.dp))
            Image(
                painterResource(R.drawable.vector_3), null
            )
            Column(Modifier.padding(top = 45.dp, start = 35.dp)) {
                Text(
                    "Selamat Datang", fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold, fontSize = 37.sp,
                    color = Color(0xFFE5E8CD)
                )
                Text(
                    "Login untuk melanjutkan!", fontFamily = Poppins,
                    fontWeight = FontWeight.Light, fontSize = 20.sp,
                    color = Color(0xFFE5E8CD)
                )
            }
        }
        Column(Modifier.padding(start = 48.dp, top = 15.dp)) {
            Text("Masuk", fontWeight = FontWeight.Bold, fontSize = 30.sp)
            OutlinedTextField(
                value = viewModel.emailUsername,
                onValueChange = { viewModel.emailUsername = it },
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = Color(0xFFD9D9D9),
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color(0xFF1C6973),
                    cursorColor = Color(0xFF1C6973)
                ),
                placeholder = {
                    Text(
                        "Username / Email",
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
                "*Masukkan Username / alamat E-mail anda",
                fontFamily = Poppins,
                fontWeight = FontWeight.ExtraLight,
                fontSize = 13.sp,
                modifier = Modifier.padding(bottom = 14.dp)
            )
            OutlinedTextField(
                value = viewModel.password,
                onValueChange = { viewModel.password = it },
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = Color(0xFFD9D9D9),
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color(0xFF1C6973),
                    cursorColor = Color(0xFF1C6973)
                ),
                placeholder = {
                    Text(
                        "Password",
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Light,
                        color = Color(0xFF909090)
                    )
                },
                textStyle = TextStyle(Color.Black),
                visualTransformation = visualTransformation,
                modifier = Modifier.width(320.dp),
                trailingIcon = passwordIcon
            )
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(end = 55.dp, top = 7.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    IconButton(
                        onClick = { viewModel.rememberMe = !viewModel.rememberMe },
                        Modifier.size(22.dp)
                    ) {
                        Icon(
                            painterResource(rememberMeIcon), null,
                            Modifier.size(22.dp), tint = tint
                        )
                    }
                    Text(
                        "Ingat Saya",
                        fontFamily = Poppins,
                        fontWeight = FontWeight.ExtraLight,
                        fontSize = 13.sp,
                        modifier = Modifier.padding(start = 5.dp)
                    )
                }

                ClickableText(
                    text = AnnotatedString("Lupa Password?"),
                    style = TextStyle(
                        textDecoration = TextDecoration.Underline,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.ExtraLight,
                        fontSize = 13.sp,
                        color = MaterialTheme.colors.onSurface
                    ),
                    onClick = { }
                )
            }
            Button(
                onClick = { },
                shape = RoundedCornerShape(25.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF1C6973)),
                modifier = Modifier
                    .width(330.dp)
                    .padding(end = 18.dp, top = 25.dp)
            ) {
                Text(
                    "Sign In",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 5.dp)
                )
            }
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(
                    "Or",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.ExtraLight,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(end = 50.dp, top = 10.dp, bottom = 10.dp)
                )
            }
            Button(
                onClick = { },
                shape = RoundedCornerShape(25.dp),
                border = BorderStroke(1.dp, Color(0xFF1C6973)),
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier
                    .width(330.dp)
                    .padding(end = 18.dp)
            ) {
                Image(
                    painterResource(R.drawable.google), null,
                    Modifier.padding(end = 15.dp)
                )
                Text(
                    "Sign In With Google",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(vertical = 12.dp),
                    color = Color(0xFF1C6973)
                )
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(end = 50.dp, top = 15.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    "Belum memiliki akun? ",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.ExtraLight,
                    fontSize = 17.sp,
                )
                ClickableText(
                    text = AnnotatedString("Daftar"),
                    style = TextStyle(
                        textDecoration = TextDecoration.Underline,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.ExtraLight,
                        fontSize = 17.sp,
                        color = Color(0xFF1C6973)
                    ),
                    onClick = navigateToSignUp
                )
            }
        }
    }
}