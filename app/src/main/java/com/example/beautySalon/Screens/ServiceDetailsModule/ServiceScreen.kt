package com.example.beautySalon.Screens.ServicesModule

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.beautySalon.Managers.Service
import com.example.beautySalon.NavigationItem
import com.example.beautysalon_android.R

@Composable
fun ServiceScreen(service: Service?, navController: NavHostController) {

    val padding = 16.dp
    Column(
        Modifier
            .padding(padding)
            .fillMaxWidth()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = service?.name?: "", fontSize = 30.sp)
        }
        Spacer(Modifier.size(padding))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = service?.price.toString(), fontSize = 20.sp)
        }
        Spacer(Modifier.size(padding))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = service?.description?: "", fontSize = 13.sp)
        }
        Button(
            onClick = {
                navController.navigate(NavigationItem.Enroll.route + "/${service?.name?: ""}")
            },
            modifier = Modifier
                .padding(vertical = dimensionResource(id = R.dimen.padding_8dp))
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.BitterSweet),
                contentColor = Color.White
            )
        ) {
            Text(text = stringResource(id = R.string.enroll), modifier = Modifier.padding(8.dp))
        }
    }
}






