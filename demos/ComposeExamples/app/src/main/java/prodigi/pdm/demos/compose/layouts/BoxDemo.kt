package prodigi.pdm.demos.compose.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import prodigi.pdm.demos.compose.ui.theme.ComposeExamplesTheme

@Composable
fun BoxOverlayDemo() {
    Box(modifier = Modifier.fillMaxWidth().height(140.dp).padding(all = 16.dp)) {
        Box(Modifier.matchParentSize().background(Color(0xFFEEEEEE)))
        Text(
            text = "Legenda",
            modifier = Modifier
                .align(Alignment.BottomStart)
                .background(Color(0xAA000000))
                .padding(horizontal = 8.dp, vertical = 4.dp),
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable fun BoxOverlayDemoPreview() {
    ComposeExamplesTheme { BoxOverlayDemo() }
}

@Composable
fun BoxAlignDemo() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .padding(all = 16.dp)
            .border(width = 1.dp, color = Color.Red)
    ) {
        Text(text = "TopStart", modifier = Modifier.align(Alignment.TopStart))
        Text(text = "Center", modifier = Modifier.align(Alignment.Center))
        Text(text = "BottomEnd", modifier = Modifier.align(Alignment.BottomEnd))
    }
}

@Preview(showBackground = true)
@Composable fun BoxAlignDemoPreview() {
    ComposeExamplesTheme { BoxAlignDemo() }
}
