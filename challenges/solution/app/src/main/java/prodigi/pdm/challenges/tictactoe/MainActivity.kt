package prodigi.pdm.challenges.tictactoe

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import prodigi.pdm.challenges.tictactoe.ui.theme.TicTacToeTheme
import prodigi.pdm.challenges.tictactoe.utils.LoggingActivity

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
                onAboutClick = navigateToAbout(),
                onPlayClick = navigateToGame()
            )
        }
    }
}

@Composable
fun MainScreenContent(onAboutClick: () -> Unit = {}, onPlayClick: () -> Unit = {}) {
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
                Button(onClick = onPlayClick) {
                    Text(text = stringResource(id = R.string.main_screen_play_button_text))
                }
                Button(onClick = onAboutClick) {
                    Text(text = stringResource(id = R.string.main_screen_about_button_text))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenContentPreview() {
    TicTacToeTheme {
        MainScreenContent()
    }
}