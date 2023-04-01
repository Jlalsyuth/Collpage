package com.example.collpage.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.collpage.R
import com.example.collpage.getInputColor
import com.example.collpage.ui.SearchViewModel
import com.example.collpage.ui.theme.Poppins

@Composable
fun SearchPage(viewModel: SearchViewModel = viewModel()) {
    Column(Modifier.padding(horizontal = 8.dp).padding(top = 20.dp, bottom = 12.dp)) {
        Row(Modifier.fillMaxWidth(), Arrangement.SpaceAround) {
            Box(Modifier.padding(top = 7.dp)) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painterResource(R.drawable.back_arrow), null)
                }
            }
            OutlinedTextField(
                viewModel.query,
                { viewModel.query = it },
                Modifier.width(280.dp).padding(end = 10.dp),
                shape = RoundedCornerShape(35.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = getInputColor(),
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color(0xFF1C6973),
                    cursorColor = Color(0xFF1C6973)
                ),
                trailingIcon = {
                    Icon(painterResource(R.drawable.search), null)
                },
                placeholder = {
                    Text("Search...", fontFamily = Poppins, color = Color(0xFF909090))
                }
            )
            Surface(Modifier.padding(top = 7.dp), CircleShape, Color(0xFF1C6973)) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painterResource(R.drawable.filter), null, tint = Color.White)
                }
            }
        }
        Text("Riwayat", fontFamily = Poppins, fontWeight = FontWeight.SemiBold, fontSize = 24.sp)
    }
}