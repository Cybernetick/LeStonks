package personal.vankhulup.lestonks.android

import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Inject
import personal.vankhulup.lestonks.Greeting


@Inject
class MainScreen(private val greeting: Greeting) {
  suspend fun greet(): String = greeting.callLoad()
}

@Component
abstract class MainScreenComponent(@Component val applicationComponent: ApplicationComponent) {
  abstract val screen: MainScreen
}