package org.shubham.airline.tabs

import airline.composeapp.generated.resources.Res
import airline.composeapp.generated.resources.profile
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import org.jetbrains.compose.resources.painterResource

object ProfileTab : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val title="Profile"
            val icon=painterResource(Res.drawable.profile)
            return remember { TabOptions(index = 0u, title = title, icon = icon) }
        }

    @Composable
    override fun Content() {
        TODO("Not yet implemented")
    }
}