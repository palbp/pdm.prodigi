package prodigi.pdm.challenges.tictactoe

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import prodigi.pdm.challenges.tictactoe.ui.theme.TicTacToeTheme
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
            GameScreenContent()
        }
    }
}

@Composable
fun GameScreenContent() {
    TicTacToeTheme {
        Scaffold(
            topBar = { Text(text = stringResource(id = R.string.app_name)) },
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize().padding(paddingValues = innerPadding)
            ) {
                Text(text = stringResource(id = R.string.game_screen_content))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameScreenContentPreview() {
    GameScreenContent()
}