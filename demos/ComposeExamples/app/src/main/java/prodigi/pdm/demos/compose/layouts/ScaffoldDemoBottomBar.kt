package prodigi.pdm.demos.compose.layouts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
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
fun ScaffoldDemoBottomBar() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Título") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) { Icon(Icons.Default.Add, contentDescription = null) }
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = true,  onClick = {},
                    icon = { Icon(Icons.Default.Home, null) },
                    label = { Text("Home") }
                )
                NavigationBarItem(
                    selected = false, onClick = {},
                    icon = { Icon(Icons.Default.Favorite, null) },
                    label = { Text("Favs") }
                )
                NavigationBarItem(
                    selected = false, onClick = {},
                    icon = { Icon(Icons.Default.Settings, null) },
                    label = { Text("Defs") }
                )
            }
        }
    ) { inner ->
        Box(Modifier.fillMaxSize().padding(inner), contentAlignment = Alignment.Center) {
            Text("Conteúdo")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable fun ScaffoldDemoBottomBarPreview() {
    ComposeExamplesTheme {
        ScaffoldDemoBottomBar()
    }
}