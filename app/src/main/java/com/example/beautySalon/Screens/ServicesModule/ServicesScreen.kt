package com.example.beautySalon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.beautySalon.Managers.ServicesManager
import com.example.beautySalon.Screens.ServicesModule.Views.ServiceView
import com.example.beautysalon_android.R

@Composable
fun ServicesScreen(servicesViewModel: ServicesManager, navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(id = R.string.servicesHeader),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 25.sp
        )
        LazyColumn(
            modifier = Modifier
                .padding(10.dp)
                .background(colorResource(id = R.color.Cultured))
        ) {

            servicesViewModel.services.map {
                item {
                    ServiceView(
                        service = it,
                        onItemClick = { name ->
                            navController.navigate(NavigationItem.Service.route + "/${name}")
                        }
                    )
                }
            }
        }
    }
}