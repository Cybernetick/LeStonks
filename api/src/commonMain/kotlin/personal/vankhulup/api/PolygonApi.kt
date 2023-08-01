package personal.vankhulup.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class PolygonApi {

  private val client = HttpClient() {
    install(ContentNegotiation) {
      json(Json {
        ignoreUnknownKeys = true
        useAlternativeNames = false
      })
    }
    install(Auth) {
      bearer {
        loadTokens {
          BearerTokens(accessToken = BuildConfig.POLYGON_API_KEY, "")
        }
      }
    }
  }

  suspend fun getDailyOpenClose(): OpenCloseData {
    return client.get() {
      url("https://api.polygon.io/v1/open-close/AAPL/2023-01-09?adjusted=true")
    }.body()
  }
}