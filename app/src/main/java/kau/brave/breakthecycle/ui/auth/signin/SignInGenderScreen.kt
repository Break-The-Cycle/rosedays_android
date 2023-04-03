package kau.brave.breakthecycle.ui.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kau.brave.breakthecycle.domain.model.ApplicationState
import kau.brave.breakthecycle.utils.Constants.ONBOARD_ROUTE

@Composable
fun SignInGenderScreen(appstate: ApplicationState) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "SignIn Screen")
        Button(onClick = {
            appstate.navController.navigate(ONBOARD_ROUTE)
        }) {
            Text(text = "Navigate to OnBoard Screen")
        }
    }
}