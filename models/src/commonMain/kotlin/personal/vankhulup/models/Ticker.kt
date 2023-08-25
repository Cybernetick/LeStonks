package personal.vankhulup.models

data class Ticker(
  val cik: String = "",
  val compositeFigi: String = "",
  val currencyName: String,
  val lastUpdatedUtc: String,
  val assetLocale: String,
  val marketType: String,
  val displayName: String,
  val primaryExchange: String = "",
  val tickerSymbol: String,
  val isActive: Boolean = true
)
