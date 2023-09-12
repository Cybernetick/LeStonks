package personal.vankhulup.lestonks

import me.tatarka.inject.annotations.Inject
import personal.vankhulup.data.TickersRepository

@Inject
class Greeting(private val repository: TickersRepository) {

  suspend fun callLoad(): String {
    val result = repository.loadTickers()
    return "loaded ${result.size} items"
  }
}