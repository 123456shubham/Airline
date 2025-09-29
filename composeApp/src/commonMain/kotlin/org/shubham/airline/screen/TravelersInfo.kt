package org.shubham.airline.screen

import airline.composeapp.generated.resources.Res
import airline.composeapp.generated.resources.add
import airline.composeapp.generated.resources.flight
import airline.composeapp.generated.resources.indigo
import airline.composeapp.generated.resources.left_arrow
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
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
import org.shubham.airline.components.PaymentScreen
import org.shubham.airline.components.Spacer_10dp
import org.shubham.airline.components.Spacer_20dp
import org.shubham.airline.components.Spacer_32dp
import org.shubham.airline.components.Spacer_4dp
import org.shubham.airline.components.SubtitleLarge
import org.shubham.airline.model.Passenger
import org.shubham.airline.ui.theme.black
import org.shubham.airline.ui.theme.grey
import org.shubham.airline.ui.theme.skyBlue
import org.shubham.airline.ui.theme.white

object TravelersInfo : Screen, HideBottomBar{
    @Composable
    override fun Content() {
        TravelersUI()
    }

}

@Composable
fun TravelersUI(){

    val navigator= LocalNavigator.currentOrThrow

    LazyColumn {
        item {
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
                                .padding(start = 16.dp)
                                .size(18.dp),
                            colorFilter = ColorFilter.tint(white)
                        )

                        // Title centered
                        SubtitleLarge(
                            text = "Book a Flight",
                            textColour = white,
                            modifier = Modifier.align(Alignment.Center)
                        )

                    }

                    Card(modifier = Modifier.fillMaxWidth().offset(y= (-20).dp)
                        .padding(start = 20.dp, end = 20.dp),
                        colors = CardDefaults.cardColors(white),
                        elevation = CardDefaults.cardElevation(10.dp)
                    ){
                        CommonTextView("Travels Info",
                            textAlign = TextAlign.Center,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = black,
                            modifier = Modifier.fillMaxWidth().padding(vertical = 15.dp))

                    }







                }

            }

        }

        item {
            Spacer_20dp()

            TravelInfoUI()
        }

        item {
            Spacer_20dp()
            TravelPassenger()
        }

        item {
            Spacer_20dp()
            PassengerContactInformation()
        }
        item {
            Spacer_20dp()
            TravelConditionCheck()
        }
        item {
            Spacer_20dp()
            AppButton("Continue",background=skyBlue, onClick = {navigator.push(PaymentScreen)}, paddingStart = 20.dp, paddingEnd = 20.dp)
        }
    }

}


@Composable
fun TravelInfoUI(){


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


@Composable
fun TravelPassenger(){
    Card(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(white)
    ){
        Spacer_10dp()
        CommonTextView("Select Passenger ", fontSize = 12.sp, color = grey, modifier = Modifier.padding(horizontal = 10.dp))
        Spacer_10dp()
        Row(modifier = Modifier.padding(horizontal = 10.dp)) {
            Image(painterResource(Res.drawable.add), contentDescription = "add", modifier = Modifier.size(18.dp))
            Spacer_4dp()
            CommonTextView("Add New  Passenger ", fontSize = 16.sp, color = Color.Black, textAlign = TextAlign.Center)
        }
        Spacer_10dp()


    }

}

@Composable
fun PassengerContactInformation(){
    Card(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(white)
    ){
        Spacer_10dp()
        CommonTextView("Contact Information ", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = black, modifier = Modifier.padding(horizontal = 10.dp))
        Spacer_10dp()
        Divider(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp), color = grey, thickness = 1.dp)

        Spacer_10dp()
        CommonTextView("Name ", fontWeight = FontWeight.Bold, fontSize = 12.sp, color = grey, modifier = Modifier.padding(horizontal = 10.dp))
        CommonTextView("Shubham Chauhan ", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = black, modifier = Modifier.padding(horizontal = 10.dp))
        Spacer_10dp()

        CommonTextView("Phone ", fontWeight = FontWeight.Bold, fontSize = 12.sp, color = grey, modifier = Modifier.padding(horizontal = 10.dp))
        CommonTextView("+91 8571056426 ", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = black, modifier = Modifier.padding(horizontal = 10.dp))
        Spacer_10dp()
        CommonTextView("Email ", fontWeight = FontWeight.Bold, fontSize = 12.sp, color = grey, modifier = Modifier.padding(horizontal = 10.dp))
        CommonTextView("princechauhan31081997@gmail.com ", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = black, modifier = Modifier.padding(horizontal = 10.dp))
        Spacer_10dp()

        Spacer_10dp()

    }
}



@Composable
fun TravelConditionCheck(
    onCheckedChange: (Boolean) -> Unit = {}
) {
    var checked by rememberSaveable { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = checked,
                onCheckedChange = {
                    checked = it
                    onCheckedChange(it)
                }
            )

            Text(
                text = "I have read and accept the Terms & Conditions",
                modifier = Modifier.padding(start = 8.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PassengerDetailsForm(
    onSubmit: (Passenger) -> Unit
) {
    var firstName by rememberSaveable { mutableStateOf("") }
    var lastName by rememberSaveable { mutableStateOf("") }
    var age by rememberSaveable { mutableStateOf("") }
    var passportNumber by rememberSaveable { mutableStateOf("") }
    var phone by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }

    // Gender dropdown
    val genders = listOf("Male", "Female", "Other")
    var expanded by rememberSaveable { mutableStateOf(false) }
    var selectedGender by rememberSaveable { mutableStateOf(genders[0]) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Passenger Details", style = MaterialTheme.typography.titleLarge)

        OutlinedTextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text("First Name") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text("Last Name") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Age") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        // Gender dropdown
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                value = selectedGender,
                onValueChange = {},
                label = { Text("Gender") },
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                genders.forEach { gender ->
                    DropdownMenuItem(
                        text = { Text(gender) },
                        onClick = {
                            selectedGender = gender
                            expanded = false
                        }
                    )
                }
            }
        }

        OutlinedTextField(
            value = passportNumber,
            onValueChange = { passportNumber = it },
            label = { Text("Passport Number") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Phone Number") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email Address") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Button(
            onClick = {
                if (firstName.isNotBlank() && lastName.isNotBlank() && email.isNotBlank()) {
                    onSubmit(
                        Passenger(
                            firstName,
                            lastName,
                            age.toIntOrNull() ?: 0,
                            selectedGender,
                            passportNumber,
                            phone,
                            email
                        )
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Passenger")
        }
    }
}

