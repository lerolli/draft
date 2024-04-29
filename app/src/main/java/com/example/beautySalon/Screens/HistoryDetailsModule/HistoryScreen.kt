 package com.example.beautySalon.Screens.HistoryModule

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.beautySalon.Managers.HistoryData
import com.example.beautySalon.Managers.Service
import com.example.beautysalon_android.R
import androidx.compose.material.Text as Text1

 @Composable
fun HistoryScreen(data: HistoryData) {
    var review by remember { mutableStateOf(TextFieldValue("")) }

    val padding = 16.dp
    Column(
        Modifier
            .padding(padding)
            .fillMaxWidth()
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text1(text = data.service.name?: "", fontSize = 30.sp)
        }
        Spacer(Modifier.size(padding))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text1(text = "Мастер: ${data.masterName}")
        }
        Spacer(Modifier.size(padding))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text1(text = "Дата и время посещения: ${data.date}")
        }
        Spacer(Modifier.size(padding))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text1(text = "Как прошла проедура?")
        }
        Surface(
            color = Color.White,
            modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_8dp))
        ) {
            OutlinedTextField(
                value = review,
                onValueChange = { review = it },
                modifier = Modifier.fillMaxWidth()
            )
        }

        Button(
            onClick = {

            },
            modifier = Modifier
                .padding(vertical = dimensionResource(id = R.dimen.padding_8dp))
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.BitterSweet),
                contentColor = Color.White
            )
        ) {
            androidx.compose.material.Text(text = "Отправить", modifier = Modifier.padding(8.dp))
        }
    }
}