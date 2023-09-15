package personal.vankhulup.api

import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import me.tatarka.inject.annotations.Provides
import platform.UIKit.UIDevice

actual interface StonksApiPlatformComponent {

  @Provides
  fun provideHttpClient(): HttpClient = HttpClient(Darwin) {
    engine {
      configureRequest {
        setAllowsCellularAccess(true)
      }
    }

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
    defaultRequest {
      header("Platform", UIDevice.currentDevice.systemName)
    }
  }
}