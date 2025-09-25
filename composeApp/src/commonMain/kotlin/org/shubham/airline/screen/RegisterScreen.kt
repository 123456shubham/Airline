package org.shubham.airline.screen

import airline.composeapp.generated.resources.Res
import airline.composeapp.generated.resources.logo
import airline.composeapp.generated.resources.mail
import airline.composeapp.generated.resources.user
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
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
import org.shubham.airline.components.Spacer_32dp
import org.shubham.airline.components.Spacer_4dp
import org.shubham.airline.components.SubtitleMedium
import org.shubham.airline.components.SubtitleSmall
import org.shubham.airline.components.TitleLarge
import org.shubham.airline.ui.theme.background
import org.shubham.airline.ui.theme.black
import org.shubham.airline.ui.theme.skyBlue
import org.shubham.airline.ui.theme.white

object RegisterScreen : Screen {
    @Composable
    override fun Content() {
        Box(modifier = Modifier.fillMaxSize().background(white)){

            // name ,phone, email, password, register button ,
            RegisterScreenUI()
        }
    }
}

@Composable
fun RegisterScreenUI(){
    var name by rememberSaveable { mutableStateOf("") }
    var phone by rememberSaveable{mutableStateOf("")}
    var email by rememberSaveable{mutableStateOf("")}
    var password by rememberSaveable{mutableStateOf("")}

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painterResource(Res.drawable.logo),
            contentDescription = null,
            modifier = Modifier.height(200.dp).fillMaxWidth().align(Alignment.TopCenter)
        )

        Spacer_32dp()
        Column(
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp)
                .align(Alignment.Center)
        ) {
            Spacer_10dp()
            TitleLarge(
                "Register",
                textColour = black,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer_4dp()
            SubtitleSmall(
                "Add details to register",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer_32dp()

            CustomOutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = "Name",
                leadingIcon = Res.drawable.user,
                singleLine = true,
                isEnabled = true,
            )


            Spacer_20dp()

            CustomOutlinedTextField(value = phone, onValueChange = {phone=it}, label = "Phone" , leadingIcon = Res.drawable.user)
            Spacer_20dp()
            CustomOutlinedTextField(value = email, onValueChange = {email=it}, label = "Email" , leadingIcon = Res.drawable.mail)
            Spacer_20dp()
            CustomPasswordField(value = password, onValueChange = {password=it}, label = "Password" , iserror = false)
            Spacer_20dp()

            // Register Button
            AppButton("Register", background= skyBlue)


        }

        Row(modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp).align(Alignment.BottomCenter), horizontalArrangement = Arrangement.Center){
            SubtitleMedium("Already have an account?", textColour = black, modifier = Modifier.align(Alignment.CenterVertically))
            SubtitleMedium("Login", textColour = skyBlue, modifier = Modifier.align(Alignment.CenterVertically))

        }
    }
}