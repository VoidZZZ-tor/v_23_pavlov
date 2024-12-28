package com.example.pavlov_v_23

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import com.example.pavlov_v_23.ui.theme.Pavlov_v_23Theme

class PersonalArea : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pavlov_v_23Theme {
                PersonalAreaScreen(
                    imageOffsetX = 100.dp,
                    imageOffsetY = 100.dp,
                    buttonOffsetX = 300.dp,
                    buttonOffsetY = 450.dp
                )
            }
        }
    }
}
@Composable
fun PersonalAreaScreen(
    imageOffsetX: Dp,
    imageOffsetY: Dp,
    buttonOffsetX: Dp,
    buttonOffsetY: Dp
) {
    val context = LocalContext.current

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val imageWidth = 120.dp
    val imageHeight = 250.dp

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text (
                "Личный кабинет",
            fontSize = 40.sp,
            color = Color.Black,
            modifier = Modifier.weight(1f)
            )
            val image1 = painterResource(id = R.drawable.exit_icon)
            Image(
                painter = image1,
                contentDescription = "Sample Image",
                modifier = Modifier
                    .offset(x = imageOffsetX, y = imageOffsetY)
                    .width(50.dp)
                    .height(50.dp)
                    .padding(bottom = 16.dp),
                contentScale = ContentScale.Crop
            )
            val image2 = painterResource(id = R.drawable.search_icon)
            Image(
                painter = image2,
                contentDescription = "Sample Image",
                modifier = Modifier
                    .offset(x = imageOffsetX, y = imageOffsetY)
                    .width(50.dp)
                    .height(50.dp)
                    .padding(bottom = 16.dp),
                contentScale = ContentScale.Crop
            )
            Text (
                "Привет, User!",
                fontSize = 40.sp,
                color = Color.Black,
                modifier = Modifier.weight(1f)
            )
            Button(
                onClick = {
                    val intent = Intent(context, Search::class.java)
                    context.startActivity(intent)
                },
                modifier = Modifier
                    .width(330.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                ),
                shape = MaterialTheme.shapes.small
            ) {
                Text("Позвонить в отделение банка", fontSize = 16.sp, color = Color.White)
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "Онлайн чат",
                    color = Color.Gray,
                    fontSize = 16.sp,
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "Настройки",
                    color = Color.Gray,
                    fontSize = 16.sp,
                )
            }
        }
    }
}