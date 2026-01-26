package prodigi.pdm.ongoing.tally

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels


const val TAG = "ConcurrencyModel"

/**
 * The host of the single screen of the Tally application
 */
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v(TAG, "onCreate in thread = ${Thread.currentThread().name}")
        enableEdgeToEdge()
        setContent {
            MainScreen(vm = viewModel)
        }
    }
}
