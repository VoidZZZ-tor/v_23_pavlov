package com.example.pavlov_v_23

import androidx.compose.runtime.Composable
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pavlov_v_23.ui.theme.Pavlov_v_23Theme

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pavlov_v_23Theme {
                LoginScreen(context = this)
            }
        }
    }
}
@Composable
fun LoginScreen(
    context: Context,
    imageOffsetX: Dp = 0.dp,
    imageOffsetY: Dp = 0.dp,
    textFieldOffsetX: Dp = 0.dp,
    textFieldOffsetY: Dp = 0.dp
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val image = painterResource(id = R.drawable.image_1)
        Image(
            painter = image,
            contentDescription = "Sample Image",
            modifier = Modifier
                .offset(x = imageOffsetX, y = imageOffsetY)
                .width(250.dp)
                .height(250.dp)
                .padding(bottom = 16.dp),
            contentScale = ContentScale.Crop
        )
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Логин:", color = Color.Gray) },
            textStyle = LocalTextStyle.current.copy(color = Color.Black),
            modifier = Modifier
                .offset(x = textFieldOffsetX, y = textFieldOffsetY)
                .fillMaxWidth(0.8f)
                .padding(bottom = 16.dp),
            shape = MaterialTheme.shapes.medium
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Пароль:", color = Color.Gray) },
            textStyle = LocalTextStyle.current.copy(color = Color.Black),
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(bottom = 16.dp),
            shape = MaterialTheme.shapes.medium
        )
        Button(
            onClick = {
                val intent = Intent(context, PersonalArea::class.java)
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
            Text("Авторизоваться", fontSize = 16.sp, color = Color.White)
        }
    }
}
