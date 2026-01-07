package prodigi.pdm.challenges.tictactoe.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import prodigi.pdm.challenges.tictactoe.R
import prodigi.pdm.challenges.tictactoe.ui.theme.TicTacToeTheme

/**
 * Tags used for UI tests.
 */
const val MAIN_SCREEN_PLAY_BUTTON_TAG = "MainScreenPlayButtonTag"
const val MAIN_SCREEN_ABOUT_BUTTON_TAG = "MainScreenAboutButtonTag"

/**
 * The main screen content.
 * @param aboutRequested function called when the user clicks the About button.
 * @param playRequested function called when the user clicks the Play button.
 */

@Composable
fun MainScreenContent(aboutRequested: () -> Unit = {}, playRequested: () -> Unit = {}) {
    TicTacToeTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize().padding(paddingValues = innerPadding)
            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.displayMedium,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(64.dp))
                Image(
                    painter = painterResource(R.drawable.im_tic_tac_toe),
                    contentDescription = "Splash Image",
                    modifier = Modifier.sizeIn(
                        80.dp, 80.dp,
                        200.dp, 200.dp
                    )
                )
                Spacer(modifier = Modifier.height(64.dp))
                Button(
                    onClick = playRequested,
                    modifier = Modifier.testTag(MAIN_SCREEN_PLAY_BUTTON_TAG)
                ) {
                    Text(
                        text = stringResource(id = R.string.main_screen_play_button_text)
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Button(
                    onClick = aboutRequested,
                    modifier = Modifier.testTag(MAIN_SCREEN_ABOUT_BUTTON_TAG)
                ) {
                    Text(
                        text = stringResource(id = R.string.main_screen_about_button_text)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenContentPreview() {
    MainScreenContent()
}
