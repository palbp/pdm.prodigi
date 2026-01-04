package prodigi.pdm.challenges.tictactoe

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
 * The Activity that shows information about the app. For now it is simply a placeholder.
 */
class AboutActivity : LoggingActivity() {

    companion object {

        /**
         * Creates a new intent used to navigate to the AboutActivity.
         * @param origin The activity from which the navigation is triggered. Because all our
         * activities inherit from LoggingActivity, we can use it the parameter type.
         */
        fun newIntent(origin: LoggingActivity) =
            android.content.Intent(origin, AboutActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AboutScreenContent()
        }
    }
}

@Composable
fun AboutScreenContent() {
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
                Text(text = stringResource(id = R.string.about_screen_content))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AboutScreenContentPreview() {
    TicTacToeTheme {
        AboutScreenContent()
    }
}