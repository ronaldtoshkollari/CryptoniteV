import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cryptonite.presentation.screens.deposit_screen.DepositScreen
import com.example.cryptonite.presentation.screens.home_screen.HomeScreen
import com.example.cryptonite.presentation.screens.news_screen.NewsScreen
import com.example.cryptonite.presentation.screens.profile_sreen.ProfileScreen

@Composable
fun Navigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "home") {

        composable("home") {
            HomeScreen(navController = navController)
        }

        composable("news") {
            NewsScreen()
        }

        composable("profile") {
            ProfileScreen()
        }

        composable("deposit"){
            DepositScreen()
        }
    }

}