package prodigi.pdm.challenges.tictactoe.game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import prodigi.pdm.challenges.tictactoe.R
import prodigi.pdm.challenges.tictactoe.ui.TopBarWithBackNavigation
import prodigi.pdm.challenges.tictactoe.ui.theme.TicTacToeTheme

/**
 * The content of the Game screen.
 * @param backRequested Callback to be invoked when the user requests to navigate back.
 */
@Composable
fun GameScreenContent(
    backRequested: () -> Unit = { }
) {
    TicTacToeTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopBarWithBackNavigation(
                    title = stringResource(id = R.string.game_screen_title),
                    onBackRequested = backRequested
                )
            }

        ) { innerPadding ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(paddingValues = innerPadding)
                    .fillMaxSize()
            ) {
                BoardView(
                    modifier = Modifier
                        .padding(all = 32.dp)
                        .fillMaxHeight(0.65f)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameScreenContentPreview() {
    GameScreenContent()
}