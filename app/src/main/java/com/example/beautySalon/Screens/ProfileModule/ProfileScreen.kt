package com.example.beautySalon.Screens.ProfileModule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.beautySalon.Managers.ProfileManager
import com.example.beautysalon_android.R

@Composable
fun ProfileScreen(profileManager: ProfileManager) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.Cultured))
            .wrapContentSize(Alignment.Center)
    ) {
        Surface(
            color = Color.White,
            modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_8dp))
        ) {
            profileManager.profile?.login?.let {
                OutlinedTextField(
                    value = it,
                    onValueChange = { profileManager.profile?.login = it },
                    label = { Text(text = stringResource(id = R.string.login)) },
                    placeholder = { Text(text = stringResource(id = R.string.login)) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        Surface(
            color = Color.White,
            modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_8dp))
        ) {
            profileManager.profile?.name?.let {
                OutlinedTextField(
                    value = it,
                    onValueChange = { profileManager.profile?.name = it },
                    label = { Text(text = stringResource(id = R.string.name)) },
                    placeholder = { Text(text = stringResource(id = R.string.name)) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        Surface(
            color = Color.White,
            modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_8dp))
        ) {
            profileManager.profile?.surname?.let {
                OutlinedTextField(
                    value = it,
                    onValueChange = { profileManager.profile?.surname = it },
                    label = { Text(text = stringResource(id = R.string.surname)) },
                    placeholder = { Text(text = stringResource(id = R.string.surname)) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        Surface(
            color = Color.White,
            modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_8dp))
        ) {
            profileManager.profile?.phone?.let {
                OutlinedTextField(
                    value = it,
                    onValueChange = { profileManager.profile?.phone = it },
                    label = { Text(text = stringResource(id = R.string.phone)) },
                    placeholder = { Text(text = stringResource(id = R.string.phone)) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        Surface(
            color = Color.White,
            modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_8dp))
        ) {
            profileManager.profile?.site?.let {
                OutlinedTextField(
                    value = it,
                    onValueChange = { profileManager.profile?.site = it },
                    label = { Text(text = stringResource(id = R.string.site)) },
                    placeholder = { Text(text = stringResource(id = R.string.site)) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        Button(
            onClick = {},
            modifier = Modifier
                .padding(vertical = dimensionResource(id = R.dimen.padding_8dp))
                .fillMaxWidth(),

            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.BitterSweet), contentColor = Color.White)
        ) {
            Text(text = stringResource(id = R.string.save), modifier = Modifier.padding(8.dp))
        }
    }
}