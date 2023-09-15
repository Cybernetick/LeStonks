package personal.vankhulup.lestonks.android

import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Inject
import personal.vankhulup.androidui.tickerslist.TickersListViewModel


@Inject
class MainScreen(private val viewModel: TickersListViewModel)

@Component
abstract class MainScreenComponent(@Component val applicationComponent: ApplicationComponent) {
  abstract val screen: TickersListViewModel

  companion object
}