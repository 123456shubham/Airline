package org.shubham.airline.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import org.shubham.airline.components.CommonTextView
import org.shubham.airline.ui.theme.white

object CheckInScreen : Screen{
    @Composable
    override fun Content() {

        Box(modifier = Modifier.fillMaxWidth().background(white)){

            CommonTextView("Online check-in facility available between 24 hour before capture", fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp).align(Alignment.Center))
        }
    }

}