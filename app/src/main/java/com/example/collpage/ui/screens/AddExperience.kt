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
fun AddExperience(viewModel: HomeViewModel){
    Column {
        Box {
            Surface(
                Modifier
                    .height(130.dp)
                    .fillMaxWidth(), color = Color(0xFF1C6973)
            ) { }
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(
                    "Tambah Pengalaman",
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = Poppins,
                    fontSize = 24.sp
                )
            }
        }
        Text("Nama Kegiatan", fontWeight = FontWeight.Medium, fontSize = 16.sp)
        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .width(320.dp)
                .padding(bottom = 20.dp)
        )
        Text("Posisi", fontWeight = FontWeight.Medium, fontSize = 16.sp)
        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .width(320.dp)
                .padding(bottom = 20.dp)
        )
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column {
                    Text("Tahun Mulai", fontWeight = FontWeight.Medium, fontSize = 16.sp)
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(5.dp),
                        border = BorderStroke(1.dp, Color(0xFF909090)),
                        colors = ButtonDefaults.buttonColors(Color.White),
                        modifier = Modifier
                            .width(50.dp)
                            .padding(end = 18.dp)
                    ){
                        Text("Bulan tahun",
                            fontSize = 12.sp,
                            fontFamily = Poppins,
                            color = Color(0xFF000000),
                            modifier = Modifier.padding(5.dp)
                        )
                    }
                }
                Column {
                    Text("Tahun Selesai", fontWeight = FontWeight.Medium, fontSize = 16.sp)
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(5.dp),
                        border = BorderStroke(1.dp, Color(0xFF909090)),
                        colors = ButtonDefaults.buttonColors(Color.White),
                        modifier = Modifier
                            .width(50.dp)
                            .padding(end = 18.dp)
                    ){
                        Text("Bulan Tahun",
                            fontSize = 12.sp,
                            fontFamily = Poppins,
                            color = Color(0xFF000000),
                            modifier = Modifier.padding(5.dp)
                        )
                    }
                }
            }
        Text("Tahun Selesai", fontWeight = FontWeight.Medium, fontSize = 16.sp)
        OutlinedTextField(
            value = "",
            shape = RoundedCornerShape(10.dp),
            onValueChange = {},
            modifier = Modifier
                .height(250.dp)
                .width(320.dp)
        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(onClick = { /*TODO*/ },
                shape = RoundedCornerShape(25.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF1C6973)),
                modifier = Modifier
                    .width(330.dp)
                    .height(70.dp)
                    .padding(end = 18.dp, top = 25.dp)
            ) {

            }
        }
    }
}