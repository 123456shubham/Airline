package org.shubham.airline

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform