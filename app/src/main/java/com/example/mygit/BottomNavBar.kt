import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mygit.HomeScreen
import com.example.profiles.ui.ProfileScreen
import com.example.profiles.ui.ProfileViewModelImpl

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.home_icon, "Home")
    object Favorites : NavigationItem("music", R.drawable.characters_icon, "Favorites")
//    object  : NavigationItem("movies", R.drawable.episodes_icon, "Episodes")
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Favorites,
//        NavigationItem.Characters
    )

    BottomNavigation(
        backgroundColor = colorResource(id = R.color.white),
        contentColor = colorResource(R.color.purple_200)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = colorResource(id = R.color.morty_blue),
                unselectedContentColor = colorResource(id = R.color.deep_gray),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@[Composable ExperimentalComposeUiApi ExperimentalMaterialApi ExperimentalFoundationApi]
fun Screens(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            ProfileScreen(profileViewModel = hiltViewModel<ProfileViewModelImpl>())
        }
//        composable(NavigationItem.Episodes.route) {
//            FavoritesScreen()
//        }
//        composable(NavigationItem.Characters.route) {
//            CharactersScreen(characterScreenViewModel = hiltViewModel<CharacterViewModelImpl>())
//        }
    }
}