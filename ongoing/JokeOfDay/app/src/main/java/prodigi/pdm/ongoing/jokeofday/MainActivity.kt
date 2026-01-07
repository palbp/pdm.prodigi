package prodigi.pdm.ongoing.jokeofday

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import prodigi.pdm.ongoing.jokeofday.ui.theme.JokeOfDayTheme

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
            JokeOfDayTheme {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize().padding(16.dp)
                ) {
                    Text(
                        text = "Joke of the Day",
                        fontSize = 32.sp,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = { navigateToAbout() }) { Text(text = "About") }
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = { navigateToJoke() }) { Text(text = "Daily joke") }
                }
            }
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
