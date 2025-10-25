package prodigi.pdm.demos.compose.coroutinesfun

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import prodigi.pdm.demos.compose.ui.theme.ComposeExamplesTheme

/**
 * An activity to demonstrate various coroutine concepts in Jetpack Compose.
 */
class CoroutinesFunActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoroutinesFunScreen()
        }
    }
}

@Composable
fun CoroutinesFunScreen() {
    var count by remember { mutableIntStateOf(0) }
    var job by remember { mutableStateOf<Job?>(null) }
    val scope = rememberCoroutineScope()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().padding(all = 16.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize().weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Count: $count", style = MaterialTheme.typography.headlineLarge)
        }
        Row {
            Button(
                onClick = {
                    if (job == null) {
                        job = scope.launch {
                            while (isActive) {
                                delay(500L)
                                count += 1
                            }
                        }
                    }
                },
                enabled = job == null,
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Start")
            }
            Button(
                onClick = {
                    job?.cancel()
                    job = null
                },
                enabled = job != null,
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Stop")
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CoroutinesFunScreenPreview() {
    ComposeExamplesTheme {
        CoroutinesFunScreen()
    }
}
