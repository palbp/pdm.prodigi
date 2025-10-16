package prodigi.pdm.demos.compose.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import prodigi.pdm.demos.compose.ui.theme.ComposeExamplesTheme

@Composable
fun LazyRowDemo(itemsCount: Int = 0) {
    LazyRow(
        contentPadding = PaddingValues(all = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(space = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(itemsCount) { idx ->
            Box(
                modifier = Modifier
                    .size(96.dp)
                    .background(Color(0xFFB39DDB)),
                contentAlignment = Alignment.Center
            ) {
                Text("#$idx", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 140)
@Composable fun LazyRowDemoPreview() {
    ComposeExamplesTheme { LazyRowDemo(itemsCount = 12) }
}