package personal.vankhulup.androidui.tickerslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import me.tatarka.inject.annotations.Inject
import personal.vankhulup.data.TickersRepository

@Inject
class TickersListViewModel(private val repo: TickersRepository) : ViewModel() {
  val viewStateFlow = MutableStateFlow(ViewState(emptyList<TickerViewState>()))

  init {
    viewModelScope.launch {
      val loaded = repo.getAllCachedStocks().map { TickerViewState.fromTicker(it) }

      viewStateFlow.tryEmit(ViewState(loaded))

    }
  }

  data class ViewState(val tickers: List<TickerViewState>)
}