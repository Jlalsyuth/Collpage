package com.example.collpage.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import com.example.collpage.R
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.collpage.helper.getInputColor
import com.example.collpage.ui.theme.Poppins

@Composable
fun MessagePage(username: String) {
    Column(Modifier.padding(horizontal = 15.dp)) {
        Text(
            buildAnnotatedString {
                withStyle(SpanStyle(color = Color(0xFF97A04A))) {
                    append("Hai, ")
                }
                append(username)
            },
            style = TextStyle(fontFamily = Poppins, fontWeight = FontWeight.Medium)
        )
        Spacer(Modifier.height(15.dp))
        Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
            Surface(Modifier.padding(end = 5.dp), CircleShape, getInputColor()) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painterResource(R.drawable.search), null)
                }
            }
            Row(Modifier.background(getInputColor(), RoundedCornerShape(15.dp))) {
                TextButton(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Text("Chat", Modifier.padding(horizontal = 5.dp))
                }
                TextButton(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Text("Grup", Modifier.padding(horizontal = 5.dp))
                }
                TextButton(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Text("Ruang", Modifier.padding(horizontal = 5.dp))
                }
            }
            Surface(Modifier.padding(start = 5.dp), CircleShape, Color(0xFF1C6973)) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painterResource(R.drawable.add), null, tint = Color.White)
                }
            }
        }
    }
}