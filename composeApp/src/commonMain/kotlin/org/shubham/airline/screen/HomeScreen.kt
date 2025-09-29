package org.shubham.airline.screen

import airline.composeapp.generated.resources.Res
import airline.composeapp.generated.resources.exchange
import airline.composeapp.generated.resources.flight
import airline.composeapp.generated.resources.girl
import airline.composeapp.generated.resources.p
import airline.composeapp.generated.resources.paris
import airline.composeapp.generated.resources.world
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import org.jetbrains.compose.resources.painterResource
import org.shubham.airline.components.CommonTextView
import org.shubham.airline.components.CustomOutlinedTextField
import org.shubham.airline.components.Spacer_10dp
import org.shubham.airline.components.Spacer_32dp
import org.shubham.airline.components.Spacer_4dp
import org.shubham.airline.components.SubtitleLarge
import org.shubham.airline.components.SubtitleMedium
import org.shubham.airline.components.TitleLarge
import org.shubham.airline.ui.theme.black
import org.shubham.airline.ui.theme.lightGrey
import org.shubham.airline.ui.theme.skyBlue
import org.shubham.airline.ui.theme.white

object HomeScreen : Screen {
    @Composable
    override fun Content() {
        HomeScreenUI()
    }
}

@Composable
fun HomeScreenUI(){

    var startTrip by rememberSaveable { mutableStateOf("") }
    var endTrip by rememberSaveable { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize().background(skyBlue)){

        Image(painterResource(Res.drawable.world), contentDescription = "World", contentScale = ContentScale.Crop, modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter))


        Column {
            Row(
                modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp, top = 30.dp)
            ) {
                Image(
                    painterResource(Res.drawable.girl),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Profile",
                    modifier = Modifier.size(48.dp).clip(CircleShape)
                )
                Spacer_10dp()
                Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                    SubtitleMedium("Welcome", modifier = Modifier,white)
                    Spacer_4dp()
                    SubtitleMedium("Shubham Chauhan", modifier = Modifier,white)
                }
            }
            Spacer_32dp()


            TitleLarge(" What is going on?", textColour = white)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(white) // White bottom container
        ) {
            Column {

                // i want  this column show half of the box
                Card(modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 30.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                    colors = CardDefaults.cardColors(containerColor =lightGrey)) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(30.dp))
                            .padding(16.dp) // inner padding
                    ) {
                        // Start Trip field
                        CustomOutlinedTextField(
                            value = startTrip,
                            onValueChange = { startTrip = it },
                            label = "Enter Start Trip",
                            borderColor = black,
                            leadingIcon = Res.drawable.flight,
                            modifier = Modifier.padding(bottom = 10.dp)
                        )

                        // Exchange icon
                        Image(
                            painter = painterResource(Res.drawable.exchange),
                            contentDescription = "Exchange",
                            modifier = Modifier
                                .padding(bottom = 10.dp)
                                .size(28.dp)
                                .align(Alignment.CenterHorizontally)
                                .rotate(90f), // 👈 rotate by 90 degrees, ,
                            colorFilter = ColorFilter.tint(skyBlue) // 👈 apply tint color

                        )

                        // End Trip field
                        CustomOutlinedTextField(
                            value = endTrip,
                            onValueChange = { endTrip = it },
                            label = "Enter End Trip",
                            borderColor = black,
                            leadingIcon = Res.drawable.flight,
                        )
                    }

                }


                Row(modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp)) {
                    SubtitleMedium("Popular Trips",  modifier = Modifier.weight(1f),black)
                    SubtitleMedium("See All", modifier = Modifier,skyBlue)
                }


                LazyRow {
                    items(10){
                        PopularTrip()
                    }
                }
            }

        }


    }

}

@Composable
fun PopularTrip(){
    Box(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(10.dp)).padding(start = 10.dp, end = 10.dp, top = 20.dp).width(100.dp).height(100.dp)){
        Image(painterResource(Res.drawable.p), contentDescription = "Paris", contentScale = ContentScale.Crop, modifier = Modifier.clip(RoundedCornerShape(10.dp)))
        CommonTextView("Paris", modifier = Modifier.align(Alignment.BottomStart ).padding(start = 10.dp, bottom = 10.dp), fontSize = 14.sp)
    }
}