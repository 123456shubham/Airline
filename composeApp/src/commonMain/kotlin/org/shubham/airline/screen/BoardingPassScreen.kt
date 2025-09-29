package org.shubham.airline.screen

import airline.composeapp.generated.resources.Res
import airline.composeapp.generated.resources.left_arrow
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import io.github.alexzhirkevich.qrose.options.QrOptions
import io.github.alexzhirkevich.qrose.rememberQrCodePainter
import org.jetbrains.compose.resources.painterResource
import org.shubham.airline.components.CommonTextView
import org.shubham.airline.components.SubtitleLarge
import org.shubham.airline.ui.theme.black
import org.shubham.airline.ui.theme.skyBlue
import org.shubham.airline.ui.theme.white


@Composable
fun BoardingPassScreenUI() {
    val navigator= LocalNavigator.currentOrThrow
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F9FF))
    ) {
        // Header
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
            CommonTextView("Boarding Pass",
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = black,
                modifier = Modifier.fillMaxWidth().padding(vertical = 15.dp))

        }

        Spacer(modifier = Modifier.height(16.dp))

        // Boarding Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Flight Info Row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("From", color = Color.Gray, fontSize = 14.sp)
                        Text("CMB", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                        Text("Colombo", color = Color.Gray, fontSize = 12.sp)
                    }

                    Text("✈", fontSize = 28.sp, color = Color(0xFF1BA9F5))

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("To", color = Color.Gray, fontSize = 14.sp)
                        Text("DXB", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                        Text("Dubai", color = Color.Gray, fontSize = 12.sp)
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Details Grid
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text("Terminal", color = Color.Gray, fontSize = 12.sp)
                            Text("02", fontWeight = FontWeight.Bold)
                        }
                        Column {
                            Text("Gate", color = Color.Gray, fontSize = 12.sp)
                            Text("02", fontWeight = FontWeight.Bold)
                        }
                        Column {
                            Text("Seat", color = Color.Gray, fontSize = 12.sp)
                            Text("16E-20E", fontWeight = FontWeight.Bold)
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text("Date", color = Color.Gray, fontSize = 12.sp)
                            Text("03 Jan 2021", fontWeight = FontWeight.Bold)
                        }
                        Column {
                            Text("Boarding", color = Color.Gray, fontSize = 12.sp)
                            Text("02", fontWeight = FontWeight.Bold)
                        }
                        Column {
                            Text("Seat", color = Color.Gray, fontSize = 12.sp)
                            Text("16E-20E", fontWeight = FontWeight.Bold)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // QR Code with flight info
                QrCodeBox(
                    content = "Flight:CMB-DXB|Date:03-01-2021|Terminal:02|Gate:02|Seat:16E-20E"
                )
            }
        }
    }
}

@Composable
fun QrCodeBox(content: String) {
    Box(
        modifier = Modifier
            .size(160.dp)
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        val painter = rememberQrCodePainter(
            data = content,
            options = QrOptions()
        )
        Image(
            painter = painter,
            contentDescription = "QR Code",
            modifier = Modifier.fillMaxSize()
        )
    }
}
object BoardingPassScreen : Screen{
    @Composable
    override fun Content() {
        BoardingPassScreenUI()
    }

}

