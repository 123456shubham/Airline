package org.shubham.airline.tabs

import airline.composeapp.generated.resources.Res
import airline.composeapp.generated.resources.flight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.painter.Painter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import org.jetbrains.compose.resources.painterResource

object FlightTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = "Flight"
            val icon: Painter = painterResource(Res.drawable.flight)
            return remember { TabOptions(index = 0u, title = title, icon = icon) }
        }

    @Composable
    override fun Content() {
        TODO("Not yet implemented")
    }

}