package org.shubham.airline.bottomNavigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import org.shubham.airline.tabs.HomeTab

object BottomTabs : Screen {
    @Composable
    override fun Content() {
        MainAppWithBottomTabs()
    }
}


@Composable
fun MainAppWithBottomTabs() {
    var showBottomBar by remember { mutableStateOf(true) }

    CompositionLocalProvider(
        LocalShowBottomBar provides { visible ->
            showBottomBar = visible
        }
    ) {
        TabNavigator(HomeTab) { tabNavigator ->

            Scaffold(
                bottomBar = {
                    if (showBottomBar) AppBottomBar()
                }
            ) { innerPadding ->
                Box(modifier = Modifier.padding(innerPadding)) {
                    CurrentTab()
                }
            }
        }
    }
}