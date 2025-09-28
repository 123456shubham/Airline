package org.shubham.airline.screen

import airline.composeapp.generated.resources.Res
import airline.composeapp.generated.resources.add_ons
import airline.composeapp.generated.resources.boarding_pass
import airline.composeapp.generated.resources.booking
import airline.composeapp.generated.resources.calendar
import airline.composeapp.generated.resources.check
import airline.composeapp.generated.resources.checklist
import airline.composeapp.generated.resources.list
import airline.composeapp.generated.resources.right_arrow
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.jetbrains.compose.resources.painterResource
import org.shubham.airline.components.Spacer_20dp
import org.shubham.airline.components.Spacer_4dp
import org.shubham.airline.components.SubtitleLarge
import org.shubham.airline.components.SubtitleMedium
import org.shubham.airline.components.TitleMedium
import org.shubham.airline.components.TitleSmall
import org.shubham.airline.model.FlightItemModel
import org.shubham.airline.ui.theme.black
import org.shubham.airline.ui.theme.skyBlue
import org.shubham.airline.ui.theme.white

object FlightsScreen : Screen {
    @Composable
    override fun Content() {
        FlightScreenUI()
    }

}

@Composable
fun FlightScreenUI() {
    val navigator= LocalNavigator.currentOrThrow

    val flightItemList=listOf(
        FlightItemModel("Book a Flight", Res.drawable.booking),
        FlightItemModel("Manage Booking", Res.drawable.list),
        FlightItemModel("Check In", Res.drawable.check),
        FlightItemModel("Boarding Pass", Res.drawable.boarding_pass),
        FlightItemModel("Add-ons", Res.drawable.add_ons),
        FlightItemModel("Flight Schedule", Res.drawable.calendar),
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(white)
    ) {
        Column {
            // Top Header
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp))
                    .background(skyBlue) // apply after clip
            ) {
                SubtitleLarge(
                    text = "Flights",
                    modifier = Modifier.align(Alignment.Center),
                    textColour = white
                )
            }

           Spacer_20dp()

            LazyColumn {
                items(flightItemList.size){flightItemLists->
                    FlightsScreenItem(flightItemList[flightItemLists]){ name ->
                        when (name) {
                            "Book a Flight" -> navigator.push(BookingFlightScreen)
                            "Manage Booking" -> { navigator.push(ManageBooking)}
                            "Check In" -> { /* handle navigation */ }
                            "Boarding Pass" -> { /* handle navigation */ }
                            "Add-ons" -> { /* handle navigation */ }
                            "Flight Schedule" -> { /* handle navigation */ }
                        }
                    }

                }
            }

        }
    }
}

@Composable
fun FlightsScreenItem(flightItemModel: FlightItemModel,
                      onClick: (String) -> Unit ){

    Card(modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp).padding(vertical = 10.dp).clickable { onClick(flightItemModel.name) },
        elevation = CardDefaults.cardElevation(5.dp),
        colors = CardDefaults.cardColors(white)){

        Row (modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp, horizontal = 10.dp)){

            Image(painterResource(flightItemModel.image), contentDescription = "Booking", modifier = Modifier.size(28.dp).align(
                Alignment.CenterVertically))
            Spacer_20dp()
            SubtitleLarge(flightItemModel.name,  modifier = Modifier.fillMaxWidth().weight(1f).align(Alignment.CenterVertically),
                black
            )
            Image(painterResource(Res.drawable.right_arrow), contentDescription = "right", modifier = Modifier.size(18.dp).align(
                Alignment.CenterVertically))

        }

    }
}