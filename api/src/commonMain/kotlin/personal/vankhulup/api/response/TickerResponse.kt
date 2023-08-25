package personal.vankhulup.api.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TickerResponse(
  @SerialName("active") val isActive: Boolean,
  @SerialName("cik") val cik: String = "",
  @SerialName("composite_figi") val compositeFigi: String = "",
  @SerialName("currency_name") val currencyName: String,
  @SerialName("last_updated_utc") val lastUpdatedUtc: String,
  @SerialName("locale") val assetLocale: AssetLocale,
  @SerialName("market") val marketType: AssetMarket,
  @SerialName("name") val displayName: String,
  @SerialName("primary_exchange") val primaryExchange: String = "",
  @SerialName("ticker") val tickerSymbol: String,
  //TODO ticker type https://polygon.io/docs/stocks/get_v3_reference_tickers_types
)