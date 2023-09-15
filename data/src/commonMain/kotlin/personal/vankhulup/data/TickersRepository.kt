package personal.vankhulup.data

import me.tatarka.inject.annotations.Inject
import personal.vankhulup.api.PolygonApi
import personal.vankhulup.dbsqldelight.daos.TickerDao
import personal.vankhulup.models.Ticker

@Inject
class TickersRepository(private val api: PolygonApi, private val db: TickerDao) {

  suspend fun loadTickers(): List<Ticker> {
    val tickers = api.queryAllTickers()
    val converted = tickers.data.map {
      Ticker(
        cik = it.cik,
        compositeFigi = it.compositeFigi,
        currencyName = it.currencyName,
        lastUpdatedUtc = it.lastUpdatedUtc,
        assetLocale = it.assetLocale.name,
        marketType = it.marketType.name,
        displayName = it.displayName,
        primaryExchange = it.primaryExchange,
        tickerSymbol = it.tickerSymbol
      )
    }
    db.insertAll(converted)
    return converted
  }

  suspend fun getAllCachedStocks(): List<Ticker> {
    var cachedData = db.getAllStockTickers()
    if (cachedData.isEmpty()) {
      loadTickers().apply {
        cachedData = db.getAllStockTickers()
      }
    }
    return cachedData
  }
}