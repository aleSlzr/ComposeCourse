package com.example.composecourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.composecourse.login.ui.LoginScreen
import com.example.composecourse.login.ui.LoginViewModel
import com.example.composecourse.ui.theme.ComposeCourseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCourseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    LoginScreen(loginViewModel)
                    //ItemTwitter()
                    //SuperHeroRecycler()
                    //SuperHeroRecyclerGrid()
                    //SuperHeroRecyclerExtraControls()
                    //SuperHeroRecyclerSticky()
                    //ScaffoldExample()
                    /*val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.Screen1.route
                    ) {
                        composable(Routes.Screen1.route) { Screen1(navigationController) }
                        composable(Routes.Screen2.route) { Screen2(navigationController) }
                        composable(Routes.Screen3.route) { Screen3(navigationController) }
                        composable(
                            Routes.Screen4.route,
                            arguments = listOf(navArgument("age") { type = NavType.IntType })
                        ) { backStackEntry ->
                            Screen4(
                                navigationController,
                                backStackEntry.arguments?.getInt("age") ?: 0
                            )
                        }
                        composable(
                            Routes.Screen5.route,
                            arguments = listOf(navArgument("name") { defaultValue = "Alia" })
                        ) { backStackEntry ->
                            Screen5(
                                navigationController,
                                backStackEntry.arguments?.getString("name").orEmpty()
                            )
                        }
                    }*/
                }
            }
        }
    }
}
