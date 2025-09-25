package org.shubham.airline.tabs

import airline.composeapp.generated.resources.Res
import airline.composeapp.generated.resources.booking
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.painter.Painter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import org.jetbrains.compose.resources.painterResource

object BookingTab : Tab{
    override val options: TabOptions
        @Composable
        get() {
            val title = "Booking"
            val icon: Painter = painterResource(Res.drawable.booking)
            return remember { TabOptions(index = 0u, title = title, icon = icon) }
        }

    @Composable
    override fun Content() {
        TODO("Not yet implemented")
    }

}