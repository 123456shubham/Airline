package org.shubham.airline.screen

import airline.composeapp.generated.resources.Res
import airline.composeapp.generated.resources.booking
import airline.composeapp.generated.resources.customer_service
import airline.composeapp.generated.resources.flight
import airline.composeapp.generated.resources.information_button
import airline.composeapp.generated.resources.insurance
import airline.composeapp.generated.resources.moon
import airline.composeapp.generated.resources.sun
import airline.composeapp.generated.resources.terms_and_conditions
import airline.composeapp.generated.resources.world
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.shubham.airline.components.CommonTextView
import org.shubham.airline.components.SubtitleLarge
import org.shubham.airline.components.SubtitleMedium
import org.shubham.airline.components.TitleMedium
import org.shubham.airline.components.TitleSmall
import org.shubham.airline.ui.theme.black
import org.shubham.airline.ui.theme.grey
import org.shubham.airline.ui.theme.skyBlue
import org.shubham.airline.ui.theme.white


object ProfileScreen : Screen{
    @Composable
    override fun Content() {
        ProfileScreenUI()
    }
}


@Composable
fun ProfileScreenUI() {
    var isDarkMode by rememberSaveable { mutableStateOf(false) }

    LazyColumn(modifier = Modifier.fillMaxSize().background(white)) {
        item {
            Box(modifier = Modifier.fillMaxSize().background(Color(0xFFF4F4F4))) {

                // Header with curved background
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp)
                        .clip(RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp))
                        .background(skyBlue)
                ) {
                    // Optional animation: rotating airplane icon
                    val rotation = rememberInfiniteTransition()
                    val angle by rotation.animateFloat(
                        initialValue = 0f,
                        targetValue = 360f,
                        animationSpec = infiniteRepeatable(
                            animation = tween(8000, easing = LinearEasing)
                        )
                    )
                    Image(
                        painter = painterResource(Res.drawable.world),
                        contentDescription = "Plane",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .rotate(angle)

                    )

                    Image(
                        painter = painterResource(Res.drawable.flight),
                        contentDescription = "Plane",
                        modifier = Modifier
                            .size(80.dp)
                            .align(Alignment.TopEnd)
                            .padding(top = 20.dp, end = 20.dp)
                            .rotate(angle)
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 140.dp)
                ) {
                    // Avatar & Name
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                            .align(Alignment.CenterHorizontally)
                    ) {
                        SubtitleLarge(
                            text = "S",
                            modifier = Modifier.align(Alignment.Center),
                            textColour = skyBlue
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    SubtitleMedium(
                        text = "Shubham Chauhan",
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        textColour = black
                    )

                    CommonTextView(
                        text = "Premium Member",
                        fontSize = 14.sp,
                        color = grey,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )


                }
            }

        }

        item {
            Spacer(modifier = Modifier.height(20.dp))

            // Stats Cards Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(white)
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ProfileStatCard("Flights", "24", Color(0xFFFFC107))
                ProfileStatCard("Miles", "12.4K", Color(0xFF4CAF50))
                ProfileStatCard("Rewards", "5", Color(0xFFE91E63))
            }

        }

        item {

            Spacer(modifier = Modifier.height(30.dp))

            // Options
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                ProfileOption("My Bookings", Res.drawable.booking)
                ProfileOption("Term & Condition", Res.drawable.terms_and_conditions)
                ProfileOption("Aboutus", Res.drawable.information_button)
                ProfileOption("Privacy Policy", Res.drawable.insurance)
                ProfileOption("Support", Res.drawable.customer_service)


                // Dark mode toggle as a card
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { isDarkMode = !isDarkMode },
                    elevation = CardDefaults.cardElevation(8.dp),
                    colors = CardDefaults.cardColors(white),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        TitleMedium("Dark Mode")

                        DarkModeToggle(isDarkMode = isDarkMode, onToggle = { isDarkMode = it })
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }

}

@Composable
fun DarkModeToggle(
    isDarkMode: Boolean,
    onToggle: (Boolean) -> Unit
) {
    val transition = updateTransition(targetState = isDarkMode, label = "DarkModeTransition")

    val thumbOffset by transition.animateDp(label = "Thumb") { dark ->
        if (dark) 24.dp else 0.dp
    }

    val trackColor by transition.animateColor(label = "Track") { dark ->
        if (dark) Color.DarkGray else Color.LightGray
    }

    Box(
        modifier = Modifier
            .width(50.dp)
            .height(28.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(trackColor)
            .clickable { onToggle(!isDarkMode) },
        contentAlignment = Alignment.CenterStart
    ) {
        Box(
            modifier = Modifier
                .offset(x = thumbOffset)
                .size(24.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(if (isDarkMode) Res.drawable.moon else Res.drawable.sun),
                contentDescription = null,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
fun ProfileStatCard(title: String, value: String, bgColor: Color) {
    Card(
        modifier = Modifier
            .width(100.dp)
            .height(80.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(bgColor)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SubtitleMedium(text = value, textColour = Color.White)
            CommonTextView(text = title, fontSize = 12.sp, color = Color.White)
        }
    }
}

@Composable
fun ProfileOption(title: String, iconRes: DrawableResource) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(white)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(iconRes),
                contentDescription = title,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            TitleSmall(title)
        }
    }
}
