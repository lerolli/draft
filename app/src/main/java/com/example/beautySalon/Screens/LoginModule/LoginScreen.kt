package com.example.beautySalon.Screens.LoginModule

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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.beautySalon.Managers.LoginScreenManager
import com.example.beautySalon.NavigationItem
import com.example.beautysalon_android.R

@Composable
fun LoginScreen(mana: LoginScreenManager, navController: NavHostController) {
    var phoneNumber by remember { mutableStateOf(TextFieldValue("")) }
    var smsCode by remember { mutableStateOf(TextFieldValue("")) }


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
            OutlinedTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = { Text(text = stringResource(id = R.string.phoneNumberHint)) },
                placeholder = { Text(text = stringResource(id = R.string.phone)) },
                modifier = Modifier.fillMaxWidth()
            )
        }
        Button(
            onClick = {
                mana.sendCode(phoneNumber.text)

            },
            modifier = Modifier
                .padding(vertical = dimensionResource(id = R.dimen.padding_8dp))
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.BitterSweet),
                contentColor = Color.White
            )
        ) {
            Text(
                text = stringResource(id = R.string.send_sms), 
                modifier = Modifier.padding(8.dp)
            )
        }

            Surface(
            color = Color.White,
            modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_8dp))
        ) {
            OutlinedTextField(
                value = smsCode,
                onValueChange = { smsCode = it },
                label = { Text(text = stringResource(id = R.string.smsCode)) },
                placeholder = { Text(text = stringResource(id = R.string.smsCode)) },
                modifier = Modifier.fillMaxWidth()
            )
        }
        Button(
            onClick = {
                if (mana.sheckCode(smsCode.text)) {
                    navController.navigate(NavigationItem.Services.route)
                }
            },
            modifier = Modifier
                .padding(vertical = dimensionResource(id = R.dimen.padding_8dp))
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.BitterSweet),
                contentColor = Color.White
            )
        ) {
            Text(
                text = stringResource(id = R.string.login_button),
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposablePreview() {
    val loginScreenViewModel = LoginScreenManager()
    LoginScreen(mana = loginScreenViewModel, navController = rememberNavController())
}