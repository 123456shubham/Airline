package org.shubham.airline.screen

import airline.composeapp.generated.resources.Res
import airline.composeapp.generated.resources.close
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.shubham.airline.components.AppButton
import org.shubham.airline.components.CommonTextView
import org.shubham.airline.components.Spacer_10dp
import org.shubham.airline.components.Spacer_20dp
import org.shubham.airline.components.Spacer_4dp
import org.shubham.airline.model.Airport
import org.shubham.airline.ui.theme.grey
import org.shubham.airline.ui.theme.skyBlue
import org.shubham.airline.ui.theme.white

object DepartureAirportScreen : Screen {
    @Composable
    override fun Content() {
        DepartureAirportScreenUI()
    }
}

@Composable
fun DepartureAirportScreenUI(){
    Box(modifier = Modifier.fillMaxSize().background(white)){

        Column(modifier = Modifier.fillMaxWidth()) {

            Spacer_10dp()
            Row (modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)){
                CommonTextView("Departure Airport", fontSize = 16.sp,  fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth().weight(1f))
                Image(painter = painterResource(Res.drawable.close), modifier = Modifier.size(24.dp).padding(end = 10.dp, top = 10.dp), contentDescription = "Close")
            }
            Spacer_4dp()
            CommonTextView("757 Bhatawarpur  Tanda,  Delhi 110036 ", fontSize = 14.sp, color = grey, modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp))
            Spacer_20dp()
            AirportListScreen()
            Spacer_20dp()
            AppButton("Show Near By Airport", modifier = Modifier.fillMaxWidth(), textColor = white, background = skyBlue)
            Spacer_20dp()
        }

    }
}


@Composable
fun AirportListScreen() {
    val allAirports = listOf(
        Airport("Abu Dhabi", "United Arab Emirates", "AUH"),
        Airport("Ad Dammam", "Saudi Arabia", "DMM"),
        Airport("Adelaide", "Australia", "ADL"),
        Airport("Amman", "Jordan", "AMM"),
        Airport("Amsterdam", "Netherlands", "AMS"),
        Airport("Ancona - Falconara Airport", "Italy", "AOI"),
        Airport("Athens", "Greece", "ATH"),
        Airport("Auckland", "New Zealand", "AKL"),
        Airport("Bahrain", "Bahrain", "BAH"),
        Airport("Bangalore", "India", "BLR"),
        Airport("Bangkok", "Thailand", "BKK"),
        Airport("Barcelona", "Spain", "BCN"),
        Airport("Bari-Bari-Palese", "Italy", "BRI"),
        Airport("Baticloa", "Sri Lanka", "BTC")
    )

    // Group airports by first letter
    val grouped = allAirports.sortedBy { it.city }
        .groupBy { it.city.first().uppercaseChar() }

    val listState = remember { LazyListState() }
    val coroutineScope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize()) {
        // Airport List
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize().padding(end = 24.dp) // leave space for sidebar
        ) {
            grouped.forEach { (letter, list) ->
                item {
                    Text(
                        text = letter.toString(),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
                items(list) { airport ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {
                        Text(
                            "${airport.city} - ${airport.country} (${airport.code})",
                            fontSize = 16.sp,
                            color = Color.Black
                        )
                    }
                    Divider()
                }
            }
        }

        // Full A–Z Sidebar
        val alphabet = ('A'..'Z').toList()

        Column(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .background(Color(0xFF009AE1)) // Sky blue
                .padding(vertical = 8.dp, horizontal = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            alphabet.forEach { letter ->
                val isActive = grouped.containsKey(letter)
                val textColor = if (isActive) Color.White else Color.LightGray

                Text(
                    text = letter.toString(),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = textColor,
                    modifier = Modifier
                        .padding(2.dp)
                        .let {
                            if (isActive) {
                                it.clickable {
                                    coroutineScope.launch {
                                        val headerIndex = grouped.keys.sorted().indexOf(letter)
                                        if (headerIndex >= 0) {
                                            listState.animateScrollToItem(headerIndex * 5) // adjust multiplier if needed
                                        }
                                    }
                                }
                            } else {
                                it // inactive, no clickable
                            }
                        }
                )
            }
        }
    }
}