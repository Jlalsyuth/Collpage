package com.example.collpage.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.collpage.ui.HomeViewModel
import com.example.collpage.ui.theme.Poppins

@Composable
fun AddProject(viewModel: HomeViewModel) {
    Column() {
        Box {
            Surface(
                Modifier
                    .height(130.dp)
                    .fillMaxWidth(), color = Color(0xFF1C6973)
            ) { }
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(
                    "Tambah Project",
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = Poppins,
                    fontSize = 24.sp
                )
            }
        }
        Text("Judul", fontWeight = FontWeight.Medium, fontSize = 16.sp)
        TextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(
                    "Collpage",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Light,
                    color = Color(0xFF909090)
                )
            },
            modifier = Modifier
                .width(320.dp)
                .padding(top = 10.dp)
        )
        Text("Tipe Project", fontWeight = FontWeight.Medium, fontSize = 16.sp)
        TextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(
                    "Aplikasi",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Light,
                    color = Color(0xFF909090)
                )
            },
            modifier = Modifier
                .width(320.dp)
                .padding(top = 10.dp)
        )
        Text("Anggota Tim", fontWeight = FontWeight.Medium, fontSize = 16.sp)
        TextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(
                    "@Bagus @Ananda",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Light,
                    color = Color(0xFF909090)
                )
            },
            modifier = Modifier
                .width(320.dp)
                .padding(top = 10.dp)
        )
        Text("Tanggal Mulai", fontWeight = FontWeight.Medium, fontSize = 16.sp)
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(
                onClick = { },
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(1.dp, Color(0xFF909090)),
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier
                    .width(169.dp)
                    .padding(end = 18.dp)
            ) {
                Text(
                    "Bulan",
                    fontSize = 12.sp,
                    fontFamily = Poppins,
                    color = Color(0xFF000000),
                    modifier = Modifier.padding(5.dp)
                )
            }
            Button(
                onClick = { },
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(1.dp, Color(0xFF909090)),
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier
                    .width(169.dp)
                    .padding(end = 18.dp)
            ) {
                Text(
                    "Bulan",
                    fontSize = 12.sp,
                    fontFamily = Poppins,
                    color = Color(0xFF000000),
                    modifier = Modifier.padding(5.dp)
                )
            }
        }
        Text("Tanggal Selesai", fontWeight = FontWeight.Medium, fontSize = 16.sp)
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(
                onClick = { },
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(1.dp, Color(0xFF909090)),
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier
                    .width(160.dp)
                    .padding(end = 18.dp)
            ) {
                Text(
                    "Bulan",
                    fontSize = 12.sp,
                    fontFamily = Poppins,
                    color = Color(0xFF000000),
                    modifier = Modifier.padding(5.dp)
                )
            }
            Button(
                onClick = { },
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(1.dp, Color(0xFF909090)),
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier
                    .width(160.dp)
                    .padding(end = 18.dp)
            ) {
                Text(
                    "Tahun",
                    fontSize = 12.sp,
                    fontFamily = Poppins,
                    color = Color(0xFF000000),
                    modifier = Modifier.padding(5.dp)
                )
            }
        }
        Text("Deskripsi", fontWeight = FontWeight.Medium, fontSize = 16.sp)
        OutlinedTextField(
            value = "",
            shape = RoundedCornerShape(10.dp),
            onValueChange = {},
            modifier = Modifier
                .height(250.dp)
                .width(320.dp)
        )
    }
}