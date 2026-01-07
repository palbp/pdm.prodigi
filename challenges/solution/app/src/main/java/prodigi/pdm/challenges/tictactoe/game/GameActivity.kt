package prodigi.pdm.challenges.tictactoe.game

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
            GameScreenContent(
                backRequested = { finish() }
            )
        }
    }
}
