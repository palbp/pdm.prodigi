package prodigi.pdm.demos.compose.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import prodigi.pdm.demos.compose.ui.theme.ComposeExamplesTheme

@Composable
fun RowWeightDemo() {
    Row(Modifier.fillMaxWidth().height(48.dp).padding(all = 16.dp)) {
        Box(Modifier.weight(1f).fillMaxHeight().background(Color(0xFFBBDEFB)))
        Box(Modifier.weight(2f).fillMaxHeight().background(Color(0xFFC8E6C9)))
        Box(Modifier.weight(1f).fillMaxHeight().background(Color(0xFFFFCCBC)))
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 96)
@Composable fun RowWeightDemoPreview() {
    ComposeExamplesTheme { RowWeightDemo() }
}