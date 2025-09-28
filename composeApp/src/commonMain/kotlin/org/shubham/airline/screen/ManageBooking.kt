package org.shubham.airline.screen

import airline.composeapp.generated.resources.Res
import airline.composeapp.generated.resources.flight
import airline.composeapp.generated.resources.indigo
import airline.composeapp.generated.resources.left_arrow
import airline.composeapp.generated.resources.right_arrow
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.jetbrains.compose.resources.painterResource
import org.shubham.airline.HideBottomBar
import org.shubham.airline.components.AppButton
import org.shubham.airline.components.CommonTextView
import org.shubham.airline.components.Spacer_10dp
import org.shubham.airline.components.Spacer_20dp
import org.shubham.airline.components.Spacer_32dp
import org.shubham.airline.components.Spacer_4dp
import org.shubham.airline.components.SubtitleLarge
import org.shubham.airline.ui.theme.ButtonDark
import org.shubham.airline.ui.theme.black
import org.shubham.airline.ui.theme.grey
import org.shubham.airline.ui.theme.lightBlue
import org.shubham.airline.ui.theme.skyBlue
import org.shubham.airline.ui.theme.white
import org.shubham.airline.ui.theme.yellowColor

object ManageBooking : Screen, HideBottomBar {
    @Composable
    override fun Content() {
        ManageBookingUI()
    }
}

@Composable
fun ManageBookingUI(){

    val navigator= LocalNavigator.currentOrThrow

    Box(modifier = Modifier.fillMaxSize().background(white)){
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp))
                    .background(skyBlue) // apply after clip
            ) {

                // Back button aligned to start
                Image(
                    painter = painterResource(Res.drawable.left_arrow),
                    contentDescription = "Back Btn",
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .clickable{navigator.pop()}
                        .padding(start = 16.dp)
                        .size(18.dp),
                    colorFilter = ColorFilter.tint(white)
                )

                // Title centered
                SubtitleLarge(
                    text = "Manage Booking",
                    textColour = white,
                    modifier = Modifier.align(Alignment.Center)
                )

            }

            Card(modifier = Modifier.fillMaxWidth().offset(y= (-20).dp)
                .padding(start = 20.dp, end = 20.dp),
                colors = CardDefaults.cardColors(white),
                elevation = CardDefaults.cardElevation(10.dp)
            ){
                CommonTextView("Upcoming Trips",
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = black,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 15.dp))

            }

          Spacer_10dp()
            LazyColumn {
                items(10){
                    UpcomingTripsItem()

                }

            }

        }

    }

}


@Composable
fun UpcomingTripsItem(){

    Card(modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp, top =20.dp),
        colors = CardDefaults.cardColors(white),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(10.dp)
        ) {

        Column {
            Row (modifier = Modifier.fillMaxWidth().background(ButtonDark)){
                Spacer_4dp()
                Image(painterResource(Res.drawable.flight), contentDescription = "Flight", modifier = Modifier.size(28.dp).align(Alignment.CenterVertically), colorFilter = ColorFilter.tint(white))
                CommonTextView(" Trip 001",
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = white,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 15.dp).weight(1f))
                Image(painterResource(Res.drawable.right_arrow), contentDescription = "Flight", modifier = Modifier.size(16.dp).align(Alignment.CenterVertically),colorFilter = ColorFilter.tint(white))
                Spacer_4dp()

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Departure
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier.padding(start = 10.dp)
                ) {
                    CommonTextView("From", fontSize = 12.sp, color = Color.Black)
                    CommonTextView("CMB", fontSize = 20.sp, color = Color.Black, fontWeight = FontWeight.Bold)
                    CommonTextView("Colombo", fontSize = 12.sp, color = Color.Black)
                }

                // Flight path with airplane
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.zIndex(2f) // airplane icon in the topmost layer
                ) {
                    Image(
                        painter = painterResource(Res.drawable.flight),
                        contentDescription = "Flight",
                        modifier = Modifier.size(28.dp)
                    )
                }

                // Arrival
                Column(
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier.padding(end = 10.dp)
                ) {
                    CommonTextView("To", fontSize = 12.sp, color = Color.Black)
                    CommonTextView("DXB", fontSize = 20.sp, color = Color.Black, fontWeight = FontWeight.Bold)
                    CommonTextView("Dubai", fontSize = 12.sp, color = Color.Black)
                }
            }
        }
        CommonTextView("28 Sep 2025 | 02 Adults", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth(), fontSize = 20.sp, color = Color.Black, fontWeight = FontWeight.Bold)

        Row(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp)){
            Spacer_10dp()

            Image(painterResource(Res.drawable.indigo), contentDescription = "logo", modifier = Modifier.size(28.dp).align(
                Alignment.CenterVertically))
            Spacer_10dp()
            CommonTextView("Ind009", fontSize = 16.sp, modifier = Modifier.fillMaxWidth().weight(1f).align(
                Alignment.CenterVertically), color = black, fontWeight = FontWeight.Bold)
            CommonTextView("Flight Info", fontSize = 16.sp, modifier = Modifier.fillMaxWidth().weight(1f).align(
                Alignment.CenterVertically), color = grey, fontWeight = FontWeight.Bold)
            CommonTextView("₹8900", fontSize = 22.sp, color = yellowColor, fontWeight = FontWeight.Bold, modifier = Modifier.align(
                Alignment.CenterVertically))
            Spacer_10dp()

        }

        Divider(modifier = Modifier.fillMaxWidth().height(1.dp), color = grey)
        Spacer_20dp()
        AppButton("Customize Booking",background=skyBlue, onClick = {}, paddingStart = 20.dp, paddingEnd = 20.dp)
        Spacer_20dp()
    }
}
