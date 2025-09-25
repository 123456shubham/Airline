package org.shubham.airline.bottomNavigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import org.shubham.airline.tabs.BookingTab
import org.shubham.airline.tabs.CheckInTab
import org.shubham.airline.tabs.FlightTab
import org.shubham.airline.tabs.HomeTab
import org.shubham.airline.tabs.ProfileTab
import org.shubham.airline.ui.theme.skyBlue


@Composable
fun AppBottomBar() {
    val tabNavigator = LocalTabNavigator.current
    val items = listOf(BookingTab, FlightTab, HomeTab, CheckInTab, ProfileTab)

    NavigationBar(
        containerColor = Color.White
    ) {
        items.forEach { tab ->
            val selected = tabNavigator.current == tab
            NavigationBarItem(
                selected = selected,
                onClick = { tabNavigator.current = tab },
                icon = {
                    tab.options.icon?.let { painter ->
                        Image(
                            painter = painter,
                            contentDescription = tab.options.title,
                            modifier = Modifier.size(20.dp),
                            colorFilter = ColorFilter.tint(
                                if (selected) skyBlue else Color.Gray
                            ) // ✅ icon color changes
                        )
                    }
                },
                label = {
                    Text(
                        text = tab.options.title ?: "",
                        color = if (selected) skyBlue else Color.Gray // ✅ text color changes
                    )
                },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent // remove default highlight
                )
            )
        }
    }
}



//@Composable
//fun AppBottomBar() {
//    val tabNavigator = LocalTabNavigator.current
//    val items = listOf(BookingTab, FlightTab, HomeTab, CheckInTab, ProfileTab)
//
//    NavigationBar(
//        containerColor = Color.White,) {
//        items.forEach { tab ->
//            val selected = tabNavigator.current == tab
//            NavigationBarItem(
//                selected = selected,
//                onClick = { tabNavigator.current = tab },
//                icon = {
//                    tab.options.icon?.let { painter ->
//                        Image(painter = painter, contentDescription = tab.options.title, modifier = Modifier.size(20.dp))
//                    }
//                },
//                label = {
//                    Text(text = tab.options.title ?: "")
//                },
//                alwaysShowLabel = true
//            )
//        }
//    }
//}