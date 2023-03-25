package com.example.collpage.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.collpage.R
import com.example.collpage.ui.theme.Poppins

@Composable
fun EmailCheck(
    navigateToLogin: () -> Unit
) {
    Column {
        Box {
            Image(painterResource(R.drawable.vector_3), null, Modifier.padding(top = 22.dp))
            Image(
                painterResource(R.drawable.vector_6), null
            )
            Column(Modifier.padding(top = 45.dp, start = 35.dp)) {
                Text(
                    "Cek E-mail Anda", fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold, fontSize = 37.sp,
                    color = Color(0xFFE5E8CD)
                )
            }
        }
        Spacer(Modifier.height(20.dp))
        Text(
            "Kami telah mengirimkan link ubah password pada e-mail Anda. " +
                    "SIlahkan di cek pada kotak E-mail Anda.",
            fontWeight = FontWeight.Light,
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 30.dp)

        )
        Button(
            onClick = navigateToLogin,
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF1C6973)),
            modifier = Modifier
                .width(260.dp)
                .padding(start = 30.dp, top = 15.dp)
        ) {
            Text(
                "Kembali ke Login",
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                color = Color.White,
            )
        }
    }
}