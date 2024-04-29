package com.example.beautySalon.Screens.HistoryModule

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.beautySalon.Managers.HistoryManager
import com.example.beautySalon.Screens.HistoryModule.Views.HistoryView
import com.example.beautySalon.NavigationItem
import com.example.beautysalon_android.R

@Composable
fun HistoryVisitingScreen(historyManager: HistoryManager, navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "История посещений",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 25.sp
        )
        LazyColumn {
            historyManager.history.map {
                item {
                    HistoryView(
                        it,
                        onItemClick = { data ->
                            navController.navigate(NavigationItem.History.route + "/${data.service.name}/${data.masterName}/${data.date}")
                        })
                }
            }
        }
    }
}