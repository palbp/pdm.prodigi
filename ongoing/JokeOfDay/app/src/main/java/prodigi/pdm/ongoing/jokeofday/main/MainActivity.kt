package prodigi.pdm.ongoing.jokeofday.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import prodigi.pdm.ongoing.jokeofday.about.AboutActivity
import prodigi.pdm.ongoing.jokeofday.joke.JokeActivity

const val TAG = "JokeOfDay:MainActivity"

class MainActivity : ComponentActivity() {

    fun navigateToAbout() {
        Log.v(TAG, "Navigate to AboutActivity from instance ${hashCode()}")
        startActivity(Intent(this, AboutActivity::class.java))
    }

    private fun navigateToJoke() {
        Log.v(TAG, "Navigate to JokeActivity from instance ${hashCode()}")
        startActivity(Intent(this, JokeActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v(TAG, "onCreate called on instance ${hashCode()}")
        enableEdgeToEdge()
        setContent {
            MainScreenContent(
                onAboutNavigate = { navigateToAbout() },
                onJokeNavigate = { navigateToJoke() }
            )
        }
    }

    override fun onStart() {
        super.onStart()
        Log.v(TAG, "onStart called on instance ${hashCode()}")
    }

    override fun onStop() {
        super.onStop()
        Log.v(TAG, "onStop called on instance ${hashCode()}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG, "onDestroy called on instance ${hashCode()}")
    }
}
