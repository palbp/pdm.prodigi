package prodigi.pdm.challenges.tictactoe.game.ui

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import prodigi.pdm.challenges.tictactoe.game.domain.Coordinate
import prodigi.pdm.challenges.tictactoe.game.domain.Game
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
        val orientation = LocalConfiguration.current.orientation
        if (orientation == Configuration.ORIENTATION_PORTRAIT)
            GameScreenRootViewPortrait(game, makeMoveRequested, restartGameRequested, backRequested)
        else
            GameScreenRootViewLandscape(game, makeMoveRequested, restartGameRequested, backRequested)
    }
}
