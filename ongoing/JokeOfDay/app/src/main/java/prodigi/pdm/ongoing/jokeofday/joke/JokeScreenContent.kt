@file:OptIn(ExperimentalMaterial3Api::class)

package prodigi.pdm.ongoing.jokeofday.joke

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import prodigi.pdm.ongoing.jokeofday.R
import prodigi.pdm.ongoing.jokeofday.ui.theme.JokeOfDayTheme

@Composable
fun JokeScreenContent(onBackNavigation: () -> Unit = {}) {
    JokeOfDayTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = stringResource(R.string.app_name)) },
                    navigationIcon = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                            contentDescription = "Back",
                            modifier = Modifier.clickable { onBackNavigation() }
                        )
                     },
                )
            },
            floatingActionButton = {
                Button(onClick = { /* TODO: Load new joke */ }) {
                    Text(text = stringResource(R.string.joke_button_text))
                }
            },
        ) { innerPadding ->
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                Text(text = "Joke Screen Content")
            }
        }
    }
}

@Preview
@Composable
fun JokeScreenContentPreview() {
    JokeScreenContent()
}