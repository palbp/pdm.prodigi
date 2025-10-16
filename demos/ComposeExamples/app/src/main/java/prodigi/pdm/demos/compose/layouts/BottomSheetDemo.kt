package prodigi.pdm.demos.compose.layouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import prodigi.pdm.demos.compose.ui.theme.ComposeExamplesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalBottomSheetDemo() {
    ModalBottomSheet(onDismissRequest = {}) {
        Column(
            Modifier.fillMaxWidth().padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Folha de opções",
                style = MaterialTheme.typography.titleMedium
            )
            Text("Ação 1")
            Text("Ação 2")
            Text("Ação 3")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable fun ModalBottomSheetDemoPreview() {
    ComposeExamplesTheme { ModalBottomSheetDemo() }
}