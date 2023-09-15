package personal.vankhulup.androidui.tickerslist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType

@Composable
fun TickersList(data: List<TickerViewState>) {
  LazyColumn {
    items(data) {
      TickerListItem(item = it)
    }
  }
}

@Composable
fun TickerListItem(modifier: Modifier = Modifier, item: TickerViewState) {
  Card(modifier = Modifier.padding(horizontal = Dp(4f), vertical = Dp(2f))) {
    Row(
      modifier = modifier
        .fillMaxWidth()
        .padding(horizontal = Dp(8f), vertical = Dp(12f)), verticalAlignment = Alignment.CenterVertically
    ) {
      Box(modifier = Modifier.fillMaxWidth(fraction = 0.2f), contentAlignment = Alignment.Center) {
        AutoResizeText(
          modifier = modifier
            .background(color = Color.LightGray.copy(alpha = 0.5f), shape = RoundedCornerShape(size = Dp(2f)))
            .padding(horizontal = Dp(16f), vertical = Dp(8f))
            .fillMaxWidth(),
          textAlign = TextAlign.Center,
          fontSizeRange = FontSizeRange(min = TextUnit(11f, TextUnitType.Sp), max = TextUnit(15f, TextUnitType.Sp)),
          fontWeight = FontWeight(600),
          maxLines = 1,
          color = Color.White,
          text = item.tickerShortName
        )
      }
      Column {
        Text(
          modifier = Modifier
            .wrapContentSize()
            .padding(start = Dp(16f)),
          fontSize = TextUnit(17f, TextUnitType.Sp),
          fontWeight = FontWeight(500),
          maxLines = 2,
          overflow = TextOverflow.Ellipsis,
          color = Color.Black,
          text = item.tickerFullDisplayName
        )

        Text(
          modifier = Modifier
            .wrapContentSize()
            .padding(start = Dp(16f), top = Dp(8f)),
          fontSize = TextUnit(14f, TextUnitType.Sp),
          fontWeight = FontWeight(400),
          color = Color.Black,
          text = stringResource(id = R.string.asset_locale_format, item.tickerAssetLocal)
        )
      }
    }
  }
}


@Preview
@Composable
fun TickerListItemPreview() {
  TickerListItem(item = TickerViewState(tickerShortName = "AAON", tickerFullDisplayName = "Aaon Inc", tickerAssetLocal = "US"))
}
