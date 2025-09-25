package org.shubham.airline.tabs

import airline.composeapp.generated.resources.Res
import airline.composeapp.generated.resources.home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.painter.Painter
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import org.jetbrains.compose.resources.painterResource
import org.shubham.airline.HideBottomBar
import org.shubham.airline.bottomNavigation.LocalShowBottomBar
import org.shubham.airline.screen.HomeScreen

object HomeTab : Tab {

    override val options: TabOptions
        @Composable
        get()  {
            val title = "Home"
            val icon: Painter = painterResource(Res.drawable.home)
            return remember { TabOptions(index = 0u, title = title, icon = icon) }
        }

    @Composable
    override fun Content() {
        val updateBottomBar = LocalShowBottomBar.current
        Navigator(HomeScreen) { navigator ->
            val currentScreen = navigator.items.lastOrNull() // ✅ get current screen from stack
            updateBottomBar(currentScreen !is HideBottomBar)
            CurrentScreen()
        }
    }
}