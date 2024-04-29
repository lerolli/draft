package com.example.beautySalon.Screens.ServicesModule.Views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.beautySalon.Managers.Service
import com.example.beautysalon_android.R

@Composable
fun ServiceView(service: Service, onItemClick:(name:String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.CadetBlueCrayola))
            .border(
                width = 1.dp,
                color = colorResource(id = R.color.Charcoal),
                shape = RoundedCornerShape(5.dp)
            )
            .padding(all = 10.dp)
            .clickable { onItemClick(service.name ?: "") }) {


        Column {
            Text(
                text = service.name ?: "",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Цена ${service.price} рублей",
                fontSize = 16.sp
            )
        }
    }
}

@Preview
@Composable
fun ComposablePreview() {
    ServiceView(service = Service("ф", "a", 1, "1"), {})
}