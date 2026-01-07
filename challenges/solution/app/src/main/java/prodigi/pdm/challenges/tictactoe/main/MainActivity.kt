package prodigi.pdm.challenges.tictactoe.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import prodigi.pdm.challenges.tictactoe.about.AboutActivity
import prodigi.pdm.challenges.tictactoe.game.GameActivity
import prodigi.pdm.challenges.tictactoe.utils.LoggingActivity

/**
 * The activity for the main screen of the app.
 */
class MainActivity : LoggingActivity() {

    private fun navigateToAbout(): () -> Unit = {
        startActivity(AboutActivity.newIntent(this))
    }

    private fun navigateToGame(): () -> Unit = {
        startActivity(GameActivity.newIntent(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreenContent(
                aboutRequested = navigateToAbout(),
                playRequested = navigateToGame()
            )
        }
    }
}
