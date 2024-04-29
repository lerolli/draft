package com.example.beautySalon.Screens.HistoryModule.Views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.beautySalon.Managers.HistoryData
import com.example.beautySalon.Managers.Service
import com.example.beautysalon_android.R

@Composable
fun HistoryView(data: HistoryData, onItemClick:(historyData: HistoryData) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = colorResource(id = R.color.Charcoal),
                shape = RoundedCornerShape(5.dp)
            )
            .padding(all = 10.dp)
        .clickable { onItemClick(data) }) {

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = data.service.name ?: "")
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Мастер: ${data.masterName}")
            Text(text = "Дата и время посещения: ${data.date}")
        }
    }
}