package org.shubham.airline.bottomNavigation

import androidx.compose.runtime.staticCompositionLocalOf

// CompositionLocal to let child screens notify main scaffold about bottom bar visibility
val LocalShowBottomBar = staticCompositionLocalOf<(Boolean) -> Unit> { {} }