package com.example.collpage.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.collpage.R
import com.example.collpage.ui.HomeViewModel
import com.example.collpage.ui.theme.Poppins

@Composable
fun EditProfil(
    viewModel: HomeViewModel
){
    Column {
        Box {
            Surface(
                Modifier
                    .height(130.dp)
                    .fillMaxWidth(), color = Color(0xFF1C6973)
            ) { }
            Row(
                Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painterResource(R.drawable.ironman),
                    null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(130.dp)
                )
            }
        }
        Column(Modifier.padding(start = 30.dp, top = 15.dp)) {
            Text("Biodata",
                fontFamily = Poppins,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(top = 10.dp)
            )
            Text("Nama Lengkap*",
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 10.dp)
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .width(320.dp)
                    .padding(top = 5.dp)
                )
            Text("Tempat, Tanggal Lahir*",
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 15.dp)
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .width(320.dp)
                    .padding(top = 5.dp)
            )
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .width(60.dp)
                        .padding(top = 5.dp)
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .width(120.dp)
                        .padding(top = 5.dp)
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .width(80.dp)
                        .padding(top = 5.dp)
                )
            }
            Text("Jenis Kelamin*",
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 15.dp)
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .width(320.dp)
                    .padding(top = 5.dp)
            )
            Text("Alamat*",
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 15.dp)
            )
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .width(120.dp)
                        .padding(top = 5.dp)
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .width(120.dp)
                        .padding(top = 5.dp)
                )
            }
            OutlinedTextField(
                value = "",
                onValueChange = {},
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .width(320.dp)
                    .padding(top = 5.dp)
            )
            Text("Agama",
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 15.dp)
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .width(320.dp)
                    .padding(top = 5.dp)
            )
        }

    }
}