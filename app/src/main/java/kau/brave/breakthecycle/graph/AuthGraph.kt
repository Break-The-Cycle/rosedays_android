package kau.brave.breakthecycle.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import kau.brave.breakthecycle.ui.model.ApplicationState
import kau.brave.breakthecycle.ui.auth.login.LoginIdPasswdScreen
import kau.brave.breakthecycle.utils.Constants.AUTH_GRAPH
import kau.brave.breakthecycle.utils.Constants.LOGIN_ROUTE

fun NavGraphBuilder.authGraph(appState: ApplicationState) {
    navigation(
        route = AUTH_GRAPH,
        startDestination = LOGIN_ROUTE
    ) {
        composable(LOGIN_ROUTE) {
            LoginIdPasswdScreen(appState)
        }
    }
}