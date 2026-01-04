package prodigi.pdm.challenges.tictactoe.utils

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity


/**
 * An abstract activity that logs its lifecycle events. We are not logging all lifecycle events,
 * just those we are focusing on in the course.
 */
abstract class LoggingActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v(javaClass.simpleName, "onCreate called on instance ${hashCode()}")
    }

    override fun onStart() {
        super.onStart()
        Log.v(javaClass.simpleName, "onStart called on instance ${hashCode()}")
    }

    override fun onStop() {
        super.onStop()
        Log.v(javaClass.simpleName, "onStop called on instance ${hashCode()}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(javaClass.simpleName, "onDestroy called on instance ${hashCode()}")
    }
}