package kau.brave.breakthecycle.ui.auth.signin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kau.brave.breakthecycle.R
import kau.brave.breakthecycle.domain.model.ApplicationState
import kau.brave.breakthecycle.ui.theme.Main
import kau.brave.breakthecycle.utils.Constants.MAIN_GRAPH
import kau.brave.breakthecycle.utils.Constants.ONBOARD_CYCLE_ROUTE
import kau.brave.breakthecycle.utils.Constants.SIGNIN_GRAPH
import kau.brave.breakthecycle.utils.Constants.USERINFO_GRAPH
import kotlinx.coroutines.delay

@Composable
fun SignInCompleteScreen(appstate: ApplicationState) {

    LaunchedEffect(key1 = Unit) {
        delay(2000L)
        appstate.navController.navigate(MAIN_GRAPH) {
            popUpTo(USERINFO_GRAPH) {
                inclusive = true
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Main),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column {
            Image(
                painter = painterResource(id = R.mipmap.img_border_white_logo),
                contentDescription = "IMG_BORDER_WHITE_LOGO",
                modifier = Modifier.size(138.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "당신을 위한\n앱 준비 완료!",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}