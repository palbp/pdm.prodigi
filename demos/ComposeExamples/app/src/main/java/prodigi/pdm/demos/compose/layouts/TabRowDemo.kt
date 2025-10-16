package prodigi.pdm.demos.compose.layouts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import prodigi.pdm.demos.compose.ui.theme.ComposeExamplesTheme

@Composable
fun TabRowDemo() {
    val tabs = listOf("Info", "Fotos", "Comentários")
    Column {
        TabRow(selectedTabIndex = 0) {
            tabs.forEachIndexed { idx, title ->
                Tab(
                    selected = idx == 0,
                    onClick = {},
                    text = { Text(title) }
                )
            }
        }
        Box(
            modifier = Modifier.fillMaxWidth().height(160.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("Conteúdo da tab \"Info\"")
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 260)
@Composable fun TabRowDemoPreview() {
    ComposeExamplesTheme { TabRowDemo() }
}
