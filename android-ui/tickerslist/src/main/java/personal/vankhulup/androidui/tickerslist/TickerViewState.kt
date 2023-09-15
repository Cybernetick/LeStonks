package personal.vankhulup.androidui.tickerslist

import personal.vankhulup.models.Ticker

data class TickerViewState(val tickerShortName: String, val tickerFullDisplayName: String, val tickerAssetLocal: String) {

  companion object {
    fun fromTicker(source: Ticker): TickerViewState = TickerViewState(
      tickerShortName = source.tickerSymbol,
      tickerFullDisplayName = source.displayName,
      tickerAssetLocal = source.assetLocale
    )
  }
}
