package kau.brave.breakthecycle.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import kau.brave.breakthecycle.R
import kau.brave.breakthecycle.ui.model.ApplicationState
import kau.brave.breakthecycle.theme.White
import kau.brave.breakthecycle.utils.Constants.AUTH_GRAPH
import kau.brave.breakthecycle.utils.Constants.MAIN_GRAPH
import kau.brave.breakthecycle.utils.Constants.SPLASH_ROUTE
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(appState: ApplicationState) {

    val viewModel: SplashViewModel = hiltViewModel()

    LaunchedEffect(key1 = Unit) {
        delay(2000L)
        viewModel.loginCheck(
            navigateToLogin = {
                appState.navController.navigate(AUTH_GRAPH) {
                    popUpTo(SPLASH_ROUTE) {
                        inclusive = true
                    }
                }
            },
            navigateToMain = {
                appState.navController.navigate(MAIN_GRAPH) {
                    popUpTo(SPLASH_ROUTE) {
                        inclusive = true
                    }
                }
            },
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_logo),
            contentDescription = "IMG_LOGO",
            modifier = Modifier.size(134.dp)
        )
        Text(
            text = "ROSE DAYS",
            fontSize = 39.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black, modifier = Modifier.padding(top = 10.dp)
        )

        Text(
            text = "여성 안심 어플\n안녕하세요 로즈 데이즈 입니다.",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF767676),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 18.dp)
        )
    }
}