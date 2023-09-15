package personal.vankhulup.dbsqldelight.daos

import personal.vankhulup.dbsqldelight.LeStonksDb
import personal.vankhulup.models.Ticker

class TickerDao(private val db: LeStonksDb) {

  fun insertAll(items: Collection<Ticker>) {
    db.transaction {
      items.forEach {
        db.tickersQueries.insertOne(
          cik = it.cik,
          composite_figi = it.compositeFigi,
          currency_name = it.currencyName,
          last_updated_utc = it.lastUpdatedUtc,
          asset_locale = it.assetLocale,
          market_type = it.marketType,
          display_name = it.displayName,
          primary_exchange = it.primaryExchange,
          ticker_symbol = it.tickerSymbol
        )
      }
    }
  }

  fun getAll(): List<Ticker> {
   return db.tickersQueries.selectAll(::Ticker).executeAsList()
  }

  fun getAllStockTickers(): List<Ticker> {
    return db.tickersQueries.selectAllStocks(::Ticker).executeAsList()
  }
}