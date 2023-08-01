package personal.vankhulup.lestonks

import personal.vankhulup.api.PolygonApi

class Greeting {
    private val platform: Platform = getPlatform()

    suspend fun greet(): String {
        return try {
            PolygonApi().getDailyOpenClose().toString()
        } catch (e: Exception) {
            "empty"
        }
    }
}