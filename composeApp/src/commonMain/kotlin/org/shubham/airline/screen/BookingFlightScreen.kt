package org.shubham.airline.screen

import airline.composeapp.generated.resources.Res
import airline.composeapp.generated.resources.flight
import airline.composeapp.generated.resources.left_arrow
import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import org.shubham.airline.components.CommonTextView
import org.shubham.airline.components.Spacer_10dp
import org.shubham.airline.components.Spacer_20dp
import org.shubham.airline.components.Spacer_4dp
import org.shubham.airline.components.SubtitleLarge
import org.shubham.airline.ui.theme.black
import org.shubham.airline.ui.theme.grey
import org.shubham.airline.ui.theme.skyBlue
import org.shubham.airline.ui.theme.white
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.zIndex
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.jetbrains.compose.resources.painterResource
import org.shubham.airline.HideBottomBar


object BookingFlightScreen : Screen , HideBottomBar{
    @Composable
    override fun Content() {
        BookingFlightScreenUI()
    }
}

@Composable
fun BookingFlightScreenUI(){
    val navigator=LocalNavigator.currentOrThrow
    LazyColumn {
        item {

        }
    }
    Box(modifier = Modifier.fillMaxSize().background(white)){
        var selectedOption by rememberSaveable { mutableStateOf("Return") }
        val options = listOf("One way", "Return", "Multi-City")
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp))
                    .background(skyBlue) // apply after clip
            ) {

                Image(
                        painter = painterResource(Res.drawable.left_arrow),
                        contentDescription = "Back Btn",
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 16.dp)
                            .size(18.dp).clickable{navigator.pop()},
                        colorFilter = ColorFilter.tint(white)
                    )
                SubtitleLarge(
                    text = "Book a Flight",
                    modifier = Modifier.align(Alignment.Center),
                    textColour = white
                )
            }

            Card(modifier = Modifier.fillMaxWidth().offset(y= (-20).dp)
                .padding(start = 20.dp, end = 20.dp),
                colors = CardDefaults.cardColors(white),
                elevation = CardDefaults.cardElevation(10.dp)
            ){
                CommonTextView("Flight List",
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = black,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 15.dp))

            }

            FlightListUI()
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

            Spacer_20dp()
            DatePriceSelectorWithMonth()

            Spacer_10dp()
            LazyColumn {
                items(10){
                    FlightCardUI()

                }
            }
        }
    }
}


@Composable
fun DatePriceSelectorWithMonth() {
    val dates = listOf(
        Triple("6", "Wed", "₹220"),
        Triple("7", "Thu", "₹225"),
        Triple("8", "Fri", "₹230"),
        Triple("9", "Sat", "₹215"),
        Triple("10", "Sun", "₹220"),
        Triple("11", "Mon", "₹240"),
    )

    var selectedIndex by rememberSaveable { mutableStateOf(2) }
    val skyBlue = Color(0xFF00AFFF)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        // 📌 Month name on the left
        Box(
            modifier = Modifier
                .width(40.dp)
                .height(70.dp)
                .background(skyBlue),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Jan",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.rotate(-90f), // vertical text
                textAlign = TextAlign.Center
            )
        }

//        Spacer_10dp()
        Spacer_4dp()

        // 📌 Dates in LazyRow
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            itemsIndexed(dates) { index, item ->
                val isSelected = selectedIndex == index
                Card(
                    modifier = Modifier
                        .width(80.dp)
                        .height(70.dp)
                        .clickable { selectedIndex = index },
                    shape = RoundedCornerShape(6.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isSelected) skyBlue else Color.White
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(vertical = 8.dp, horizontal = 6.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "${item.first} ${item.second}",
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                            color = if (isSelected) Color.White else Color.Black,
                            textAlign = TextAlign.Center
                        )
                        Spacer_4dp()
                        Text(
                            text = item.third,
                            fontWeight = FontWeight.Bold,
                            color = if (isSelected) Color.White else Color.Black,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }


    }
}



@Composable
fun FlightCardUI() {
    val navigator=LocalNavigator.currentOrThrow
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable{navigator.push(FlightInfoScreen)}
            .padding(horizontal = 20.dp, vertical = 10.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            // Top Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("01:45", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text("CMB", fontSize = 14.sp, color = Color.Gray)
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.weight(1f)) {
                    Text("3 hrs", fontSize = 12.sp, color = Color.Gray)

                    Box(modifier = Modifier.fillMaxWidth().height(24.dp).padding(start = 30.dp, end = 30.dp), contentAlignment = Alignment.Center) {
                        Canvas(modifier = Modifier.fillMaxWidth().height(2.dp)) {
                            val dash = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                            drawLine(
                                color = Color.Gray,
                                start = androidx.compose.ui.geometry.Offset(0f, size.height / 2),
                                end = androidx.compose.ui.geometry.Offset(size.width, size.height / 2),
                                strokeWidth = 3f,
                                pathEffect = dash
                            )
                        }
                        Text("✈️", fontSize = 14.sp)
                    }
                }

                Column( horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("04:45", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text("DXB", fontSize = 14.sp, color = Color.Gray)
                }

            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Nonstop",
                fontSize = 13.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Bottom Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .background(Color.Red, RoundedCornerShape(18.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("✈️", color = Color.White, fontSize = 14.sp)
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Column {
                        Text("GE 189", fontWeight = FontWeight.Bold)
                        Text("Flight Info", fontSize = 12.sp, color = Color.Gray)
                    }
                }

                Box(
                    modifier = Modifier
                        .background(Color(0xFFFFC107), RoundedCornerShape(4.dp))
                        .padding(horizontal = 16.dp, vertical = 10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "₹220",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
            }
        }
    }
}


@Composable
fun FlightListUI() {
    val navigator=LocalNavigator.currentOrThrow

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable{navigator.push(FlightInfoScreen)}
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
                    CommonTextView("26 Sep, 10:50 AM", fontSize = 12.sp, color = Color.Black)
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
                    CommonTextView("10:50 PM", fontSize = 12.sp, color = Color.Black)
                    CommonTextView("DXB", fontSize = 20.sp, color = Color.Black, fontWeight = FontWeight.Bold)
                    CommonTextView("Dubai", fontSize = 12.sp, color = Color.Black)
                }
            }
    }
}


