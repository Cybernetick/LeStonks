package personal.vankhulup.lestonks

import personal.vankhulup.api.PolygonApi

class Greeting {
    suspend fun greet(): String {
        return try {
            val response = PolygonApi().queryAllTickers(true)
            response.toString()
        } catch (e: Exception) {
            "empty"
        }
    }
}