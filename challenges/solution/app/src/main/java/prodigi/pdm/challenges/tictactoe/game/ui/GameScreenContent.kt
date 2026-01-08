package prodigi.pdm.challenges.tictactoe.game.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import prodigi.pdm.challenges.tictactoe.R
import prodigi.pdm.challenges.tictactoe.game.domain.Game
import prodigi.pdm.challenges.tictactoe.game.domain.GameResult
import prodigi.pdm.challenges.tictactoe.game.domain.Coordinate
import prodigi.pdm.challenges.tictactoe.game.domain.getResult
import prodigi.pdm.challenges.tictactoe.ui.TopBarWithBackNavigation
import prodigi.pdm.challenges.tictactoe.ui.theme.TicTacToeTheme

const val GAME_SCREEN_GAME_STATE_MESSAGE_TAG = "GameScreen_GameStateMessage"
const val GAME_SCREEN_RESTART_GAME_BUTTON_TAG = "GameScreen_RestartGameButton"

/**
 * The content of the Game screen.
 * @param game The current game state.
 * @param makeMoveRequested Callback to be invoked when the user makes a move at a given coordinate.
 * @param restartGameRequested Callback to be invoked when the user requests to restart the game.
 * @param backRequested Callback to be invoked when the user requests to navigate back.
 */
@Composable
fun GameScreenContent(
    game: Game,
    makeMoveRequested: (at: Coordinate) -> Unit = { _ -> },
    restartGameRequested: () -> Unit = { },
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
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .padding(paddingValues = innerPadding)
                    .fillMaxSize()
            ) {
                GameMessage(game = game)
                BoardView(
                    game = game,
                    onTileSelected = makeMoveRequested,
                    modifier = Modifier
                        .padding(all = 32.dp)
                        .fillMaxHeight(0.65f)
                )
                Button(
                    onClick = restartGameRequested,
                    modifier = Modifier.testTag(GAME_SCREEN_RESTART_GAME_BUTTON_TAG)
                ) {
                    Text(text = stringResource(id = R.string.game_screen_restart_game_button_text))
                }
            }
        }
    }
}

/**
 * Displays a message about the current game state.
 * @param game The current game state.
 */
@Composable
private fun GameMessage(game: Game) {
    val message = when(val result = game.getResult()) {
        is GameResult.OnGoing -> stringResource(id = R.string.game_screen_player_turn_message, game.turn.toString())
        is GameResult.Tied -> stringResource(id = R.string.game_screen_draw_message)
        is GameResult.HasWinner -> stringResource(id = R.string.game_screen_winner_message, result.winner.toString())
    }
    Text(
        text = message,
        color = MaterialTheme.colorScheme.primary,
        style = MaterialTheme.typography.displayMedium,
        modifier = Modifier.testTag(GAME_SCREEN_GAME_STATE_MESSAGE_TAG)
    )
}

@Preview(showBackground = true)
@Composable
fun GameScreenContentPreview() {
    GameScreenContent(game = Game())
}