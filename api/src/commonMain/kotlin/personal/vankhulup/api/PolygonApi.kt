package personal.vankhulup.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import personal.vankhulup.api.response.OpenCloseData
import personal.vankhulup.api.response.PagedResponse
import personal.vankhulup.api.response.TickerResponse

class PolygonApi(private val httpClient: HttpClient) {
//  private lateinit var httpClient: HttpClient

  suspend fun getDailyOpenClose(): OpenCloseData {
    return httpClient.get {
      url("https://api.polygon.io/v1/open-close/AAPL/2023-01-09?adjusted=true")
    }.body()
  }

  suspend fun queryAllTickers(active: Boolean = true): PagedResponse<TickerResponse> {
    return httpClient.get {
      url("https://api.polygon.io/v3/reference/tickers?active=${active}")
    }.body()
  }
}