package com.example.beautySalon.Screens.EnrollModule

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavHostController
import com.example.beautySalon.Managers.EnrollManager
import com.example.beautySalon.Managers.Master
import com.example.beautySalon.Managers.Service
import com.example.beautySalon.NavigationItem
import com.example.beautysalon_android.R
import java.time.LocalDateTime

@Composable
fun EnrollScreen(enrollManager: EnrollManager, service: Service?, navController: NavHostController) {


    var masterExpanded by remember { mutableStateOf(false) }
    var timeExpanded by remember { mutableStateOf(false) }

    var time by remember { mutableStateOf("") }

    var mTextFieldSize by remember { mutableStateOf(Size.Zero) }
    var tTextFieldSize by remember { mutableStateOf(Size.Zero) }

    val mIcon = if (masterExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    val tIcon = if (timeExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    val padding = 16.dp
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.Cultured))
            .wrapContentSize(Alignment.Center)
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = service?.name?: "", fontSize = 30.sp)
        }
        Spacer(Modifier.size(padding))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = service?.price.toString(), fontSize = 20.sp)
        }
        Spacer(Modifier.size(padding))
        Surface(
            color = Color.White,
            modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_8dp))
        ) {
            OutlinedTextField(
                value = enrollManager.selectedMaster?.name?: "",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        mTextFieldSize = coordinates.size.toSize()
                    },
                label = { Text("Мастер") },
                trailingIcon = {
                    Icon(mIcon, "contentDescription",
                        Modifier.clickable { masterExpanded = !masterExpanded })
                }
            )

            DropdownMenu(
                expanded = masterExpanded,
                onDismissRequest = { masterExpanded = false },
                modifier = Modifier
                    .width(with(LocalDensity.current) { mTextFieldSize.width.toDp() })
            ) {
                enrollManager.masters.forEach { label ->
                    DropdownMenuItem(onClick = {
                        enrollManager.selectedMaster = label
                        masterExpanded = false
                    }) {
                        Text(text = label.name)
                    }
                }
            }
        }
        Surface(
            color = Color.White,
            modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_8dp))
        ) {
            OutlinedTextField(
                value = time,
                onValueChange = { time = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        tTextFieldSize = coordinates.size.toSize()
                    },
                label = { Text("Время") },
                trailingIcon = {
                    Icon(tIcon, "contentDescription",
                        Modifier.clickable { timeExpanded = !timeExpanded })
                }
            )

            DropdownMenu(
                expanded = timeExpanded,
                onDismissRequest = { timeExpanded = false },
                modifier = Modifier
                    .width(with(LocalDensity.current) { tTextFieldSize.width.toDp() })
            ) {

                (enrollManager.selectedMaster?.freeTime?: listOf()).forEach { label ->
                    DropdownMenuItem(onClick = {
                        time = label
                        timeExpanded = false
                    }) {
                        Text(text = label)
                    }
                }
            }
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
            Text(text = stringResource(id = R.string.enroll), modifier = Modifier.padding(8.dp))
        }
    }
}