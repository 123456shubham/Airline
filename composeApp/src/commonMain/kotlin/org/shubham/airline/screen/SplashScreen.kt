package org.shubham.airline.screen

import airline.composeapp.generated.resources.Res
import airline.composeapp.generated.resources.europe
import airline.composeapp.generated.resources.logo
import airline.composeapp.generated.resources.world
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import org.shubham.airline.components.BlurView
import org.shubham.airline.components.LoginRequiredScreen
import org.shubham.airline.components.TitleMedium
import org.shubham.airline.components.TitleSmall
import org.shubham.airline.ui.theme.white

object SplashScreen : Screen {
    @Composable
    override fun Content() {
        Box(modifier = Modifier.fillMaxSize().background(white)){

            SplashScreenUI()
        }

    }
}

@Composable
fun SplashScreenUI() {
    val navigator= LocalNavigator.currentOrThrow

    LaunchedEffect(Unit){
        delay(3000)
        navigator.replace(LoginScreen)

    }
    Box(modifier = Modifier.fillMaxSize().navigationBarsPadding()){
        Column(modifier = Modifier.align(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painterResource(Res.drawable.logo), contentDescription = "Logo", modifier = Modifier.height(200.dp).fillMaxWidth())
            TitleMedium("PRIMERO")
            TitleSmall("Airlines")
        }
        Image(painterResource(Res.drawable.europe), contentDescription = "Europe", modifier = Modifier.fillMaxWidth().height(100.dp).align(Alignment.BottomCenter), contentScale = ContentScale.Crop)

    }
}


