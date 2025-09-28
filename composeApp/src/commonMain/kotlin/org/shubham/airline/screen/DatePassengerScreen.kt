package org.shubham.airline.screen

import airline.composeapp.generated.resources.Res
import airline.composeapp.generated.resources.add
import airline.composeapp.generated.resources.calendar
import airline.composeapp.generated.resources.flight
import airline.composeapp.generated.resources.left_arrow
import airline.composeapp.generated.resources.minus
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
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlinx.datetime.LocalDate
import network.chaintech.kmp_date_time_picker.ui.datepicker.WheelDatePickerView
import network.chaintech.kmp_date_time_picker.utils.DateTimePickerView
import network.chaintech.kmp_date_time_picker.utils.now
import org.jetbrains.compose.resources.painterResource
import org.shubham.airline.HideBottomBar
import org.shubham.airline.components.AppButton
import org.shubham.airline.components.CommonTextView
import org.shubham.airline.components.Spacer_10dp
import org.shubham.airline.components.Spacer_20dp
import org.shubham.airline.components.Spacer_4dp
import org.shubham.airline.components.SubtitleLarge
import org.shubham.airline.components.SubtitleSmall
import org.shubham.airline.components.TitleMedium
import org.shubham.airline.components.TitleSmall
import org.shubham.airline.ui.theme.black
import org.shubham.airline.ui.theme.grey
import org.shubham.airline.ui.theme.skyBlue
import org.shubham.airline.ui.theme.white

object DatePassengerScreen : Screen {
    @Composable
    override fun Content() {

        DatePassengerScreenUI()
    }
}

@Composable
fun DatePassengerScreenUI(){
    val navigator= LocalNavigator.currentOrThrow
    var selectedOption by rememberSaveable { mutableStateOf("Return") }
    val options = listOf("One way", "Return", "Multi-City")

    Box(modifier = Modifier.fillMaxSize().background(white)){
        LazyColumn {
            item{
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .clip(RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp))
                        .background(skyBlue) // apply after clip
                ) {

                    // Back button aligned to start
//                    Image(
//                        painter = painterResource(Res.drawable.left_arrow),
//                        contentDescription = "Back Btn",
//                        modifier = Modifier
//                            .align(Alignment.CenterStart)
//                            .padding(start = 16.dp)
//                            .size(18.dp),
//                        colorFilter = ColorFilter.tint(white)
//                    )

                    // Title centered
                    SubtitleLarge(
                        text = "Book a Flight",
                        textColour = white,
                        modifier = Modifier.align(Alignment.Center)
                    )

                }
            }

            item {
                Card(modifier = Modifier.fillMaxWidth().offset(y= (-20).dp)
                    .padding(start = 20.dp, end = 20.dp),
                    colors = CardDefaults.cardColors(white),
                    elevation = CardDefaults.cardElevation(10.dp)
                ){
                    CommonTextView("Date & Add Passengers",
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = black,
                        modifier = Modifier.fillMaxWidth().padding(vertical = 15.dp))

                }
            }


            item {
                Spacer_20dp()
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    elevation = CardDefaults.cardElevation(10.dp),
                    colors = CardDefaults.cardColors(white)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(white)
                            .padding(horizontal = 5.dp, vertical = 5.dp)
                    ) {
                        options.forEach { option ->
                            CommonTextView(
                                text = option,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .weight(1f)
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(
                                        if (selectedOption == option) skyBlue else grey
                                    )
                                    .clickable { selectedOption = option }
                                    .padding(vertical = 10.dp),
                                color = if (selectedOption == option) white else Color.Black
                            )
                            if (option != options.last()) Spacer_4dp()
                        }
                    }
                }
            }


            item {
                Spacer_20dp()


                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .zIndex(1f), // ensures it appears above the background image
                    elevation = CardDefaults.cardElevation(10.dp),
                    colors = CardDefaults.cardColors(Color.White),
                    shape = RoundedCornerShape(10.dp)
                ) {
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
                            CommonTextView("From", fontSize = 14.sp, color = grey)
                            CommonTextView("CMB", fontSize = 20.sp, color = Color.Black, fontWeight = FontWeight.Bold)
                            CommonTextView("Colombo", fontSize = 14.sp, color = grey)
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
                            CommonTextView("10:50 PM", fontSize = 14.sp, color = grey)
                            CommonTextView("DXB", fontSize = 20.sp, color = Color.Black, fontWeight = FontWeight.Bold)
                            CommonTextView("Dubai", fontSize = 14.sp, color = grey)
                        }
                    }
                }
            }

            item {
                Spacer_20dp()
                DateDepartsReturnUI()
            }

            item {
                PassengerSelectorUI()
            }


            item {
                Spacer_20dp()
                ClassTravelUI()
            }

            item {
                Spacer_20dp()
                AppButton("Search Flight",background=skyBlue, onClick = {navigator.push(DepartureAirportScreen)}, paddingStart = 20.dp, paddingEnd = 20.dp)
                Spacer_20dp()

            }

        }

    }

}


@Composable
fun DateDepartsReturnUI(){

    var departDatePicker by rememberSaveable { mutableStateOf(false) }
    var returnDatePicker by rememberSaveable { mutableStateOf(false) }


    WheelDatePickerView(showDatePicker=departDatePicker,
        height = 200.dp ,
        dateTimePickerView = DateTimePickerView.BOTTOM_SHEET_VIEW,
        title = "Depart Date ",
        rowCount = 3,
        titleStyle = TextStyle(color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.Bold),
        doneLabel = "Done", // ✅ just pass text
        onDoneClick = {
            departDatePicker=false
            print("Done ${it}")
        },
        yearsRange = 1920..LocalDate.now().year,
        onDismiss = {
            departDatePicker=false
            print("Dismiss")
        }
    )


    WheelDatePickerView(showDatePicker=returnDatePicker,
        height = 200.dp ,
        dateTimePickerView = DateTimePickerView.BOTTOM_SHEET_VIEW,
        title = "Return Date ",
        rowCount = 3,
        titleStyle = TextStyle(color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.Bold),
        doneLabel = "Done", // ✅ just pass text
        onDoneClick = {
            returnDatePicker=false
            print("Done ${it}")
        },
        onDismiss = {
            returnDatePicker=false
            print("Dismiss")
        }
    )

    Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 20.dp)){

        Card(modifier = Modifier.fillMaxWidth().weight(1f)
            .padding(end = 20.dp).clickable{departDatePicker=true},
            colors = CardDefaults.cardColors(white),
            elevation = CardDefaults.cardElevation(10.dp)){
            Column(modifier = Modifier.fillMaxWidth()){
                Spacer_10dp()
                Row (modifier = Modifier.padding(horizontal = 10.dp)){
                    Image(painterResource(Res.drawable.calendar), contentDescription = "Calender", modifier = Modifier.size(14.dp))
                    Spacer_10dp()
                    CommonTextView("Depart On", modifier = Modifier.fillMaxWidth(), fontSize = 14.sp, color = grey)

                }
                Spacer_10dp()
                CommonTextView("SEP 28", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, fontSize = 24.sp, color = black)
                Spacer_10dp()

            }
        }
        Card(modifier = Modifier.fillMaxWidth()
            .weight(1f).padding(start = 20.dp).clickable{returnDatePicker=true},
            colors = CardDefaults.cardColors(white),
            elevation = CardDefaults.cardElevation(10.dp)){
            Column(modifier = Modifier.fillMaxWidth()){
                Spacer_10dp()
                Row (modifier = Modifier.padding(horizontal = 10.dp)){
                    Image(painterResource(Res.drawable.calendar), contentDescription = "Calender", modifier = Modifier.size(14.dp))
                    Spacer_10dp()
                    CommonTextView("Returns On", modifier = Modifier.fillMaxWidth(), fontSize = 14.sp, color = grey)
                }
                Spacer_10dp()
                CommonTextView("OCT 05", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, fontSize = 24.sp, color = black)
                Spacer_10dp()

            }
        }


    }
}


@Composable
fun PassengerSelectorUI() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        PassengerItemUI(
            title = "Adults",
            subtitle = "(> 11 Years)",
            initialCount = 1,
            minCount = 1 // at least 1 adult
        )
        Spacer_10dp()
        PassengerItemUI(
            title = "Children",
            subtitle = "(2 - 11 Years)",
            initialCount = 0,
            minCount = 0
        )
        Spacer_10dp()
        PassengerItemUI(
            title = "Infants",
            subtitle = "(0 - 2 Years)",
            initialCount = 0,
            minCount = 0
        )
    }
}

@Composable
fun PassengerItemUI(
    title: String,
    subtitle: String,
    initialCount: Int = 0,
    minCount: Int = 0,
    maxCount: Int = 9
) {
    var count by rememberSaveable { mutableStateOf(initialCount) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 20.dp)
            ) {
                TitleSmall(title, modifier = Modifier.fillMaxWidth())
                CommonTextView(subtitle, fontSize = 14.sp, color = grey, modifier = Modifier.fillMaxWidth())
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(end = 20.dp)
            ) {
                // Minus button
                IconButton(
                    onClick = { if (count > minCount) count-- },
                    enabled = count > minCount
                ) {
                    Image(
                        painterResource(Res.drawable.minus),
                        contentDescription = "Decrease",
                        modifier = Modifier.size(20.dp)
                    )
                }

                CommonTextView(
                    text = count.toString(),
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(horizontal = 12.dp)
                )

                // Plus button
                IconButton(
                    onClick = { if (count < maxCount) count++ },
                    enabled = count < maxCount
                ) {
                    Image(
                        painterResource(Res.drawable.add),
                        contentDescription = "Increase",
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}


@Composable
fun ClassTravelUI(){

    Card(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp), colors = CardDefaults.cardColors(white), elevation = CardDefaults.cardElevation(10.dp)) {
        Row (modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp, horizontal = 20.dp)){
            CommonTextView("Class Of Travel", modifier = Modifier.fillMaxWidth().weight(1f))
            Image(painterResource(Res.drawable.right_arrow),
                contentDescription = "Travel",
                modifier = Modifier.size(16.dp),
                colorFilter = ColorFilter.tint(black)
            )
        }

    }
}
