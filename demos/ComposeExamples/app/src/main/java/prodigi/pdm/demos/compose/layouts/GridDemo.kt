package prodigi.pdm.demos.compose.layouts

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import prodigi.pdm.demos.compose.ui.theme.ComposeExamplesTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GridDemo(items: List<String>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 140.dp),
        contentPadding = PaddingValues(all = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier
    ) {
        items(items = items, key = { it }) { item ->
            Box(
                modifier = Modifier
                    .aspectRatio(1f)
                    .background(Color(0xFFA5D6A7)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = item, color = Color(0xFF1B5E20))
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable fun GridDemoPreview() {
    val items = (1..16).map { "Card $it" }
    ComposeExamplesTheme {
        GridDemo(items, modifier = Modifier.padding(top = 32.dp))
    }
}