package org.shubham.airline.screen

import airline.composeapp.generated.resources.Res
import airline.composeapp.generated.resources.email
import airline.composeapp.generated.resources.logo
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import org.shubham.airline.ui.theme.background
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
    val navigator= LocalNavigator.currentOrThrow
    var email by rememberSaveable{mutableStateOf("")}
    var password by rememberSaveable{mutableStateOf("")}

    Box(modifier = Modifier.fillMaxSize()){
        Image(painterResource(Res.drawable.logo), contentDescription = "Logo", modifier = Modifier.height(200.dp).fillMaxWidth().align(Alignment.TopCenter))
        Spacer_32dp()
        Column(modifier = Modifier.align(Alignment.Center).padding(start = 10.dp, end = 10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer_10dp()
            TitleLarge("Login", modifier = Modifier.align(Alignment.CenterHorizontally), textColour = black)
            Spacer_4dp()
            SubtitleSmall("Add details to login", modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer_32dp()
            CustomOutlinedTextField(value = email,
                onValueChange = {email=it},
                label = "Email",
                leadingIcon = Res.drawable.email,
                keyboardType = KeyboardType.Email,
                singleLine = true,
                isEnabled = true,
                borderColor = black
                )
            Spacer_20dp()
            CustomPasswordField(value = password,
                onValueChange = {password=it},
                label = "Password",
                modifier = Modifier.align(Alignment.Start),
                iserror = false,
                borderColor = black
            )

            Spacer_10dp()
            SubtitleMedium("Forgeet Password", textColour = skyBlue, modifier = Modifier.align(Alignment.End))
            Spacer_20dp()
            AppButton( "Login", background=skyBlue)


        }

        Row(modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp).align(Alignment.BottomCenter), horizontalArrangement = Arrangement.Center) {
            SubtitleSmall("Don't have an account?", modifier = Modifier.align(Alignment.CenterVertically))
            SubtitleMedium("Register", textColour = skyBlue, modifier = Modifier.align(Alignment.CenterVertically).clickable{navigator.push(
                RegisterScreen)})
        }
    }
}
