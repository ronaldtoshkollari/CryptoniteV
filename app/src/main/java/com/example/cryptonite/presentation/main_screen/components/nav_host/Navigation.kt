import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cryptonite.presentation.main_screen.components.deposit_screen.DepositScreen
import com.example.cryptonite.presentation.main_screen.components.home_screen.HomeScreen
import com.example.cryptonite.presentation.main_screen.components.news_screen.NewsScreen
import com.example.cryptonite.presentation.main_screen.components.profile_sreen.ProfileScreen

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