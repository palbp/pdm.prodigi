package prodigi.pdm.demos.jokeofday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels

/**
 * The main activity for the Joke of the Day application.
 */
class MainActivity : ComponentActivity() {

    private val viewModel: JokeOfDayScreenViewModel by viewModels {
        JokeOfDayScreenViewModel.getFactory(
            service = (application as JokeOfDayApplication).jokeService
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JokeOfDayScreen(
                viewModel = viewModel,
                onBackIntent = { finish() }
            )
        }
    }
}
