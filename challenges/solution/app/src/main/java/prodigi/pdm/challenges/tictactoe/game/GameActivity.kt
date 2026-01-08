package prodigi.pdm.challenges.tictactoe.game

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import prodigi.pdm.challenges.tictactoe.game.domain.Game
import prodigi.pdm.challenges.tictactoe.game.ui.GameScreenContent
import prodigi.pdm.challenges.tictactoe.utils.LoggingActivity

/**
 * The Activity that shows the game screen. For now it is simply a placeholder.
 */
class GameActivity : LoggingActivity() {

    companion object {

        /**
         * Creates a new intent used to navigate to the AboutActivity.
         * @param origin The activity from which the navigation is triggered. Because all our
         * activities inherit from LoggingActivity, we can use it the parameter type.
         */
        fun newIntent(origin: LoggingActivity) =
            Intent(origin, GameActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var game by remember { mutableStateOf(value = Game()) }
            GameScreenContent(
                game = game,
                makeMoveRequested = { at -> game = game.makeMove(at) },
                restartGameRequested = { game = Game() },
                backRequested = { finish() }
            )
        }
    }
}
