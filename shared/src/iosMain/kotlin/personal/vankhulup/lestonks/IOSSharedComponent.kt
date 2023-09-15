package personal.vankhulup.lestonks

import me.tatarka.inject.annotations.Component
import personal.vankhulup.data.TickersRepository

@Component
abstract class IOSSharedComponent: SharedComponent {

  abstract val repository: TickersRepository

  companion object
}