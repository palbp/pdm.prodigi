package prodigi.pdm.demos.compose.layouts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import prodigi.pdm.demos.compose.ui.theme.ComposeExamplesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldDemoTopBar() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Título") },
                navigationIcon = { Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null) },
                actions = { Icon(Icons.Default.Settings, null) }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) { Icon(Icons.Default.Add, contentDescription = null) }
        },
    ) { inner ->
        Box(Modifier.fillMaxSize().padding(inner), contentAlignment = Alignment.Center) {
            Text("Conteúdo")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable fun ScaffoldDemoTopBarPreview() {
    ComposeExamplesTheme {
        ScaffoldDemoTopBar()
    }
}