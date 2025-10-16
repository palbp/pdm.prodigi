package prodigi.pdm.demos.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import prodigi.pdm.demos.compose.ui.theme.ComposeExamplesTheme

@Composable
fun Greeting(
    name: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val foregroundColor = Color(0xFF2DA8FC)
    Text(
        text = "Hello $name",
        style = TextStyle(
            fontSize = 32.sp,
            color = foregroundColor,
            textAlign = TextAlign.Center
        ),
        modifier = modifier
            .padding(all = 8.dp)
            .border(
                width = 1.dp,
                brush = SolidColor(foregroundColor),
                shape = RoundedCornerShape(size = 16.dp)
            )
            .padding(all = 24.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick)
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeExamplesTheme {
        Greeting(
            name = "Compose",
            onClick = {},
            modifier = Modifier.padding(top = 24.dp)
        )
    }
}
