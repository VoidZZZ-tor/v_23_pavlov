package com.example.pavlov_v_23

import androidx.compose.runtime.Composable
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.material3.Button
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pavlov_v_23.ui.theme.Pavlov_v_23Theme

class Search : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pavlov_v_23Theme {
                SearchScreen(context = this) //
            }
        }
    }
}

@Composable
fun SearchScreen(
    context: Context,
    imageOffsetX: Dp = 0.dp,
    imageOffsetY: Dp = 0.dp,
    textFieldOffsetX: Dp = 0.dp,
    textFieldOffsetY: Dp = 0.dp) {
    var username by remember { mutableStateOf("") }
    var checkbox1Checked by remember { mutableStateOf(false) }
    var checkbox2Checked by remember { mutableStateOf(false) }
    var checkbox3Checked by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.BottomStart
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                "Поиск",
                fontSize = 40.sp,
                color = Color.Black,
                modifier = Modifier.weight(1f)
            )
            val image1 = painterResource(id = R.drawable.arrow_icon)
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
                contentScale = ContentScale.Crop//
            )
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Оформить кредит", color = Color.Gray) },
                textStyle = LocalTextStyle.current.copy(color = Color.Black),
                modifier = Modifier
                    .offset(x = textFieldOffsetX, y = textFieldOffsetY)
                    .fillMaxWidth(0.8f)
                    .padding(bottom = 16.dp),
                shape = MaterialTheme.shapes.medium
            )
            }
            Button(
                onClick = {},
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(75.dp),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(containerColor = Color.White),
                enabled = false
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = "Последний запрос",
                        color = Color.Gray,
                        fontSize = 14.sp,
                    )
                    Text(
                        text = "Дебетовая карта",
                        color = Color.Black,
                        fontSize = 20.sp,
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    "Показывать прогресс обучения",
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier.weight(1f)
                )
                Checkbox(
                    checked = checkbox1Checked,
                    onCheckedChange = { checkbox1Checked = it },
                    modifier = Modifier.size(32.dp),
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Blue
                    )
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    "Напоминать об обучении",
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier.weight(1f)
                )
                Checkbox(
                    checked = checkbox2Checked,
                    onCheckedChange = { checkbox2Checked = it },
                    modifier = Modifier.size(32.dp),
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Blue
                    )
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    "Уведомлять об акциях и предложениях",
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier.weight(1f)
                )
                Checkbox(
                    checked = checkbox3Checked,
                    onCheckedChange = { checkbox3Checked = it },
                    modifier = Modifier.size(32.dp),
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Blue
                    )
                )
            }
        }
    }
