package prodigi.pdm.ongoing.tally.ui

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun TallyCounterButton(
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(onClick = onClick, enabled = enabled, modifier = modifier) {
        Text(text, fontSize = 32.sp)
    }
}

@Preview
@Composable
fun TallyCounterButtonPreview() {
    TallyCounterButton(text = "+", onClick = {})
}