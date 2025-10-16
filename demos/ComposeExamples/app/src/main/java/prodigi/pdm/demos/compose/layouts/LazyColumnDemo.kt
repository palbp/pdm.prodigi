package prodigi.pdm.demos.compose.layouts

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import prodigi.pdm.demos.compose.ui.theme.ComposeExamplesTheme

@Composable
fun LazyColumnDemo(items: List<String>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(all = 16.dp)
    ) {
        item {
            Text(
                text = "Cabeçalho",
                style = MaterialTheme.typography.titleMedium
            )
        }
        items(items = items, key = { it }) { item ->
            Text(
                text = item,
                modifier = Modifier.padding(all = 8.dp)
            )
            HorizontalDivider()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable fun LazyColumnDemoPreview() {
    ComposeExamplesTheme {
        val items = (1..50).map { "Utilizador $it" }
        LazyColumnDemo(items, modifier = Modifier.padding(top = 32.dp))
    }
}