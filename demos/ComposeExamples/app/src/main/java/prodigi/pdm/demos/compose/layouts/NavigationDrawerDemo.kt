package prodigi.pdm.demos.compose.layouts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import prodigi.pdm.demos.compose.ui.theme.ComposeExamplesTheme

@Composable
fun ModalDrawerDemo() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text(
                    text = "Menu",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleMedium
                )
                NavigationDrawerItem(
                    label = { Text("Início") },
                    selected = true,
                    onClick = {}
                )
                NavigationDrawerItem(
                    label = { Text("Favoritos") },
                    selected = false,
                    onClick = {}
                )
                NavigationDrawerItem(
                    label = { Text("Definições") },
                    selected = false,
                    onClick = {}
                )
            }
        },
    ) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Conteúdo")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable fun ModalDrawerDemoPreview() {
    ComposeExamplesTheme { ModalDrawerDemo() }
}