package personal.vankhulup.lestonks.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import personal.vankhulup.androidui.tickerslist.TickersList
import personal.vankhulup.androidui.tickerslist.TickersListViewModel

class MainActivity() : ComponentActivity() {

  private lateinit var listViewModel: TickersListViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    ApplicationComponent.Companion
    listViewModel = MainScreenComponent.create(ApplicationComponent.create(application)).screen
    setContent {
      MyApplicationTheme {
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colorScheme.background
        ) {
          val state by listViewModel.viewStateFlow.collectAsState()
          TickersList(data = state.tickers)
        }
      }
    }
  }


  @Preview
  @Composable
  fun DefaultPreview() {
    MyApplicationTheme {
      Column {
        Button(onClick = {
        }) {
          Text(text = "push to load")
        }
      }
    }
  }
}
