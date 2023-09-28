package personal.vankhulup.androidui.tickerslist

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType

@Composable
fun TickersList(data: List<TickerViewState>) {
  LazyColumn(contentPadding = PaddingValues(vertical = Dp(16f)), verticalArrangement = Arrangement.spacedBy(Dp(6f))) {
    items(data) {
      TickerListItem(item = it)
    }
  }
}

@Composable
fun TickerListItem(modifier: Modifier = Modifier, item: TickerViewState) {
  OutlinedCard(
    modifier = Modifier.padding(horizontal = Dp(4f), vertical = Dp(2f)),
    shape = RoundedCornerShape(Dp(4f)),
    border = CardDefaults.outlinedCardBorder()
      .copy(width = Dp(1f), brush = SolidColor(MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)))
  ) {
    Row(
      modifier = modifier
        .fillMaxWidth()
        .padding(horizontal = Dp(8f), vertical = Dp(12f)), verticalAlignment = Alignment.CenterVertically
    ) {
      Column {
        Text(
          modifier = modifier
            .background(color = Color.LightGray.copy(alpha = 0.5f), shape = RoundedCornerShape(size = Dp(2f)))
            .padding(vertical = Dp(2f), horizontal = Dp(4f)),
          textAlign = TextAlign.Center,
          fontSize = TextUnit(11f, TextUnitType.Sp),
          fontWeight = FontWeight(500),
          maxLines = 1,
          color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
          text = item.tickerShortName
        )
        Spacer(modifier = Modifier.height(Dp(8f)))
        Text(
          modifier = Modifier
            .fillMaxWidth(0.75f),
          fontSize = TextUnit(15f, TextUnitType.Sp),
          fontWeight = FontWeight(500),
          maxLines = 1,
          overflow = TextOverflow.Ellipsis,
          color = Color.Black,
          text = item.tickerFullDisplayName
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

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
@Composable
fun TickerListItemPreviewDark() {
  TickerListItem(item = TickerViewState(tickerShortName = "AAON", tickerFullDisplayName = "Aaon Inc", tickerAssetLocal = "US"))
}
