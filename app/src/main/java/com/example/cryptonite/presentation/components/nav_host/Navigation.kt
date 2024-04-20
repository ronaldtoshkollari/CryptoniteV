import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptonite.presentation.components.nav_host.Screens
import com.example.cryptonite.presentation.screens.wallet_screen.DepositScreen
import com.example.cryptonite.presentation.screens.home_screen.HomeScreen
import com.example.cryptonite.presentation.screens.news_screen.NewsScreen
import com.example.cryptonite.presentation.screens.profile_sreen.ProfileScreen
import com.example.cryptonite.presentation.screens.splash_screen.SplashScreen

@Composable
fun Navigation() {
    
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.Splash.name) {

        composable(Screens.Home.name) {
            HomeScreen(navController = navController)
        }

        composable(Screens.News.name) {
            NewsScreen(navController = navController)
        }

        composable(Screens.Profile.name) {
            ProfileScreen(navController = navController)
        }

        composable(Screens.Wallet.name){
            DepositScreen(navController = navController)
        }
        
        composable(Screens.Splash.name) {
            SplashScreen(navController = navController)
        }
    }

}