package personal.vankhulup.lestonks

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform