package com.example.beautySalon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.beautySalon.Screens.EnrollModule.EnrollScreen
import com.example.beautySalon.Screens.HistoryModule.HistoryVisitingScreen
import com.example.beautySalon.Screens.LoginModule.LoginScreen
import com.example.beautySalon.Managers.*
import com.example.beautySalon.Screens.HistoryModule.HistoryScreen
import com.example.beautySalon.Screens.ProfileModule.ProfileScreen
import com.example.beautySalon.Screens.ServicesModule.ServiceScreen
import com.example.beautysalon_android.R


val servicesManager = ServicesManager()
val loginManager = LoginScreenManager()
val enrollManager = EnrollManager()
val historyManager = HistoryManager()
val profileManager = ProfileManager()

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            servicesManager.getServices()
            enrollManager.getMasters()
            historyManager.getHistory()
            profileManager.getInfoProfile()
            MainScreen()

        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {},
        bottomBar = { BottomNavigationBar(navController) },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                Navigation(navController = navController)
            }
        },
        backgroundColor = colorResource(R.color.Cultured)
    )
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Login.route) {
        composable(NavigationItem.Services.route) {
            ServicesScreen(servicesManager, navController)
        }
        composable(NavigationItem.HistoryVisiting.route) {
            HistoryVisitingScreen(historyManager, navController)
        }
        composable(NavigationItem.Profile.route) {
            ProfileScreen(profileManager)
        }
        composable(NavigationItem.Login.route) {
            LoginScreen(loginManager, navController)
        }
        composable(
            NavigationItem.Service.route + "/{serviceName}",
            arguments = listOf(navArgument("serviceName") { type = NavType.StringType })
        )
        { backStackEntry ->
            val serviceName = backStackEntry.arguments?.getString("serviceName")
            val service = servicesManager.services.find { it.name == serviceName }
            ServiceScreen(service, navController)
        }
        composable(
            NavigationItem.Enroll.route + "/{serviceName}",
            arguments = listOf(navArgument("serviceName") { type = NavType.StringType })
        )
        { backStackEntry ->
            val serviceName = backStackEntry.arguments?.getString("serviceName")?: ""
            val service = servicesManager.services.find { it.name == serviceName }?: Service("", "", 1, "2")
            EnrollScreen(enrollManager, service, navController)
        }
        composable(
            NavigationItem.History.route + "/{serviceName}/{master}/{time}",
            arguments = listOf(
                navArgument("serviceName") { type = NavType.StringType },
                navArgument("master") { type = NavType.StringType },
                navArgument("time") { type = NavType.StringType },
            )
        )
        { backStackEntry ->
            val serviceName = backStackEntry.arguments?.getString("serviceName")?: ""
            val master = backStackEntry.arguments?.getString("master")?: ""
            val time = backStackEntry.arguments?.getString("time")?: ""
            val service = servicesManager.services.find { it.name == serviceName }?: Service("", "", 1, "2")
            HistoryScreen(HistoryData(master, time, service))
        }
    }
}


@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Services,
        NavigationItem.HistoryVisiting,
        NavigationItem.Profile
    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.Independence),
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon?: 0), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route)
                }
            )
        }
    }
}

sealed class NavigationItem(var route: String, var icon: Int?, var title: String) {
    object Services : NavigationItem("services", R.drawable.ic_services, "Услуги")
    object HistoryVisiting : NavigationItem("historyVisiting", R.drawable.ic_history, "История")
    object Profile : NavigationItem("profile", R.drawable.ic_profile, "Профиль")
    object Enroll : NavigationItem("enroll", null, "Запись")
    object Service : NavigationItem("service", null, "Услуга")
    object Login : NavigationItem("login", null, "Логин")
    object History : NavigationItem("history", null, "История посещения")
}