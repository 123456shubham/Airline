package org.shubham.airline.screen

import airline.composeapp.generated.resources.Res
import airline.composeapp.generated.resources.logo
import airline.composeapp.generated.resources.mail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.jetbrains.compose.resources.painterResource
import org.shubham.airline.bottomNavigation.BottomTabs
import org.shubham.airline.components.AppButton
import org.shubham.airline.components.CustomOutlinedTextField
import org.shubham.airline.components.CustomPasswordField
import org.shubham.airline.components.Spacer_10dp
import org.shubham.airline.components.Spacer_20dp
import org.shubham.airline.components.Spacer_28dp
import org.shubham.airline.components.Spacer_32dp
import org.shubham.airline.components.Spacer_4dp
import org.shubham.airline.components.SubtitleMedium
import org.shubham.airline.components.SubtitleSmall
import org.shubham.airline.components.TitleLarge
import org.shubham.airline.ui.theme.black
import org.shubham.airline.ui.theme.skyBlue
import org.shubham.airline.ui.theme.white

object LoginScreen : Screen {
    @Composable
    override fun Content() {
        Box(modifier = Modifier.fillMaxSize().background(white)){

            LoginScreenUI()
        }
    }
}

@Composable
fun LoginScreenUI(){

    val navigator=LocalNavigator.currentOrThrow
    var email by rememberSaveable{mutableStateOf("")}
    var password by rememberSaveable{mutableStateOf("")}
    Box(modifier = Modifier.fillMaxSize().navigationBarsPadding()){
        Image(painterResource(Res.drawable.logo), contentDescription = "Logo", modifier = Modifier.fillMaxWidth().height(200.dp).align(
            Alignment.TopCenter))
        Column(modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp).align(Alignment.Center)) {

            Spacer_10dp()
            TitleLarge("Login", textColour = black, modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer_4dp()
            SubtitleSmall("Add details to login", modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer_32dp()
            CustomOutlinedTextField(value = email,
                onValueChange = {email=it},
                label = "Email",
                leadingIcon = Res.drawable.mail,
                keyboardType = KeyboardType.Email,
                singleLine = true,
                isEnabled = true,
                modifier = Modifier.fillMaxWidth())
            Spacer_20dp()
            CustomPasswordField(value = password,
                onValueChange = {password=it}, label = "Password",
                iserror = false,
                modifier = Modifier.align(Alignment.Start))
            Spacer_10dp()
            SubtitleMedium("Forgot Password?", textColour = skyBlue, modifier = Modifier.align(Alignment.End))
            Spacer_28dp()
            AppButton("Login",background=skyBlue, onClick = {navigator.replace(BottomTabs)})

        }
        Row(modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 20.dp), horizontalArrangement = Arrangement.Center) {
            SubtitleMedium("Don't have an account?", textColour = black, modifier = Modifier.align(Alignment.CenterVertically))
            SubtitleMedium("Register", textColour = skyBlue, modifier = Modifier.clickable {
                navigator.push(RegisterScreen)
            })
        }
    }
}
