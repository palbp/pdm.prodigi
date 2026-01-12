package prodigi.pdm.ongoing.jokeofday.joke

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class JokeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JokeScreenContent(
                onBackNavigation = { finish() }
            )
        }
    }
}