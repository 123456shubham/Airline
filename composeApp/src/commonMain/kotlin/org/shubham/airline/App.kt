package org.shubham.airline

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import airline.composeapp.generated.resources.Res
import airline.composeapp.generated.resources.compose_multiplatform
import cafe.adriel.voyager.navigator.Navigator
import org.shubham.airline.screen.BookingFlightScreen
import org.shubham.airline.screen.FlightInfoScreen
import org.shubham.airline.screen.FlightsScreen
import org.shubham.airline.screen.HomeScreen
import org.shubham.airline.screen.LoginScreen
import org.shubham.airline.screen.ManageBooking
import org.shubham.airline.screen.RegisterScreen
import org.shubham.airline.screen.SplashScreen
import org.shubham.airline.screen.TravelersInfo

@Composable
@Preview
fun App() {

    Navigator(ManageBooking)

//    MaterialTheme {
//        var showContent by remember { mutableStateOf(false) }
//        Column(
//            modifier = Modifier
//                .background(MaterialTheme.colorScheme.primaryContainer)
//                .safeContentPadding()
//                .fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//        ) {
//            Button(onClick = { showContent = !showContent }) {
//                Text("Click me!")
//            }
//            AnimatedVisibility(showContent) {
//                val greeting = remember { Greeting().greet() }
//                Column(
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                ) {
//                    Image(painterResource(Res.drawable.compose_multiplatform), null)
//                    Text("Compose: $greeting")
//                }
//            }
//        }
//    }
}