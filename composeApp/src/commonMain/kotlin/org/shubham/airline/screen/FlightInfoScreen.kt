package org.shubham.airline.screen

import airline.composeapp.generated.resources.Res
import airline.composeapp.generated.resources.flight
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource

@Composable
fun FlightInfoScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF1A2980), // Dark blue
                        Color(0xFF26D0CE)  // Teal
                    )
                )
            )
    ) {
        // Background pattern elements
        BackgroundPattern()

        // Main content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            FlightInfoCard()
        }
    }
}

@Composable
fun BackgroundPattern() {
    // You can add more sophisticated background elements here
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Add some subtle circles or other shapes for background depth
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .size(200.dp)
                .background(
                    color = Color(0x15FFFFFF),
                    shape = RoundedCornerShape(100.dp)
                )
        )
        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .size(150.dp)
                .background(
                    color = Color(0x10FFFFFF),
                    shape = RoundedCornerShape(75.dp)
                )
        )
    }
}

@Composable
fun FlightInfoCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFFFFFF), // White
                        Color(0xFFF8F9FA)   // Light gray
                    )
                )
            )
            .padding(24.dp)
    ) {
        Column {
            // Header with date and time
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "18 Dec, 10:50",
                    color = Color(0xFF2D3748),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )

                Image(
                    painter = painterResource( Res.drawable.flight),
                    contentDescription = "Flight",
                    modifier = Modifier.size(24.dp),


                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Flight route information
            FlightRoute()

            Spacer(modifier = Modifier.height(24.dp))

            // Duration information
            FlightDuration()
        }
    }
}

@Composable
fun FlightRoute() {
    Column {
        // Departure information
        AirportInfo(
            time = "10:50",
            code = "CMB",
            city = "Colombo",
            isDeparture = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Connecting line with airplane icon
        RouteConnector()

        Spacer(modifier = Modifier.height(16.dp))

        // Arrival information
        AirportInfo(
            time = "02:50",
            code = "DXB",
            city = "Dubai",
            isDeparture = false
        )
    }
}

@Composable
fun AirportInfo(time: String, code: String, city: String, isDeparture: Boolean) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = time,
            color = Color(0xFF4A5568),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.width(80.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = code,
                color = Color(0xFF2D3748),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = city,
                color = Color(0xFF718096),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }

        // Departure/Arrival indicator
        Text(
            text = if (isDeparture) "Departure" else "Arrival",
            color = if (isDeparture) Color(0xFFE53E3E) else Color(0xFF38A169),
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(
                    color = if (isDeparture) Color(0xFFFFE5E5) else Color(0xFFF0FFF4),
                )
                .padding(horizontal = 8.dp, vertical = 4.dp)
        )
    }
}

@Composable
fun RouteConnector() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(80.dp))

        // Dotted line
        Box(
            modifier = Modifier
                .weight(1f)
                .height(1.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color(0xFFCBD5E0),
                            Color.Transparent
                        )
                    )
                )
        )

        // Airplane icon in circle
        Box(
            modifier = Modifier
                .size(32.dp)
                .background(Color(0xFF4299E1), RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(Res.drawable.flight),
                contentDescription = null,
                modifier = Modifier.size(16.dp),
            )
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .height(1.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color(0xFFCBD5E0),
                            Color.Transparent
                        )
                    )
                )
        )
    }
}

@Composable
fun FlightDuration() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Flight Duration:",
            color = Color(0xFF4A5568),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "4h 00m",
            color = Color(0xFF2D3748),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

// Preview function (for Android) - you can remove this for pure multiplatform
@Composable
fun PreviewFlightInfo() {
    FlightInfoScreen()
}