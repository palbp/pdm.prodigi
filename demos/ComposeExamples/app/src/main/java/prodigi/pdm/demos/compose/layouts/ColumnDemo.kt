package prodigi.pdm.demos.compose.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
fun ColumnDemo() {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    ) {
        Box(Modifier.fillMaxWidth().height(40.dp).background(Color(0xFFE3F2FD)))
        Box(Modifier.fillMaxWidth().height(40.dp).background(Color(0xFFFFF9C4)))
        Box(Modifier.fillMaxWidth().height(40.dp).background(Color(0xFFFFCDD2)))
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 200)
@Composable fun ColumnDemoPreview() {
    ComposeExamplesTheme { ColumnDemo() }
}