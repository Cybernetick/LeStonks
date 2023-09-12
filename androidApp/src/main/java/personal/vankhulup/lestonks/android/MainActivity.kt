package personal.vankhulup.lestonks.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

  private lateinit var screen: MainScreen

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    screen = MainScreenComponent::class.create(ApplicationComponent::class.create(application)).screen
    setContent {
      MyApplicationTheme {
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colors.background
        ) {
          val scope = rememberCoroutineScope()
          var data by remember { mutableStateOf("") }

          Column {
            GreetingView(data)
            Button(onClick = {
              scope.launch {
                data = screen.greet()
              }
            }) {
              Text(text = "push to load")
            }

          }

        }
      }
    }
  }
}

@Composable
fun GreetingView(text: String) {
  Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
  MyApplicationTheme {
    Column {
      GreetingView("result")
      Button(onClick = {
      }) {
        Text(text = "push to load")
      }

    }
  }
}
