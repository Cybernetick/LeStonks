package personal.vankhulup.api

import io.ktor.client.HttpClient
import me.tatarka.inject.annotations.Provides

expect interface StonksApiPlatformComponent

interface StonksApiComponent: StonksApiPlatformComponent {

  @Provides
  fun provideApi(httpClient: HttpClient): PolygonApi = PolygonApi(httpClient)
}