/*
 * FactScreen.kt
 *
 * This file contains the composable for displaying the useless fact screen, which presents different views based on the current UI state (Idle, Loading, Error).
 * The screen also provides a button to request a new fact. State hoisting is used, so the service is not passed directly to the composable.
 */

package prodigi.pdm.ongoing.uselessfacts.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import prodigi.pdm.ongoing.uselessfacts.FactUiState
import prodigi.pdm.ongoing.uselessfacts.UselessFact

/**
 * Displays the useless fact screen, showing different views depending on the current [prodigi.pdm.ongoing.uselessfacts.FactUiState].
 * - Idle: Shows the fact if available, or a placeholder message.
 * - Loading: Shows a progress indicator.
 * - Error: Shows an error message.
 *
 * @param state The current UI state for the screen.
 * @param onRequestNextFact Callback to request a new fact.
 * @param modifier Modifier for styling.
 */
@Composable
fun FactScreen(
    state: FactUiState,
    onRequestNextFact: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (state) {
                is FactUiState.Loading -> LoadingFactView()
                is FactUiState.Error -> ErrorFactView(state.message)
                is FactUiState.Idle -> IdleFactView(state.fact)
            }
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = onRequestNextFact,
                enabled = state !is FactUiState.Loading,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(56.dp)
            ) {
                Text("Next Fact", style = MaterialTheme.typography.titleMedium)
            }
        }
    }
}

/**
 * Displays a loading indicator while a fact is being fetched.
 */
@Composable
private fun LoadingFactView() {
    CircularProgressIndicator()
}

/**
 * Displays an error message when a fact cannot be fetched.
 *
 * @param message The error message to display.
 */
@Composable
private fun ErrorFactView(message: String) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.errorContainer),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        Text(
            text = "Error: $message",
            color = MaterialTheme.colorScheme.onErrorContainer,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(24.dp),
            textAlign = TextAlign.Center
        )
    }
}

/**
 * Displays the useless fact if available, or a placeholder message if not.
 *
 * @param fact The [UselessFact] to display, or null if not available.
 */
@Composable
private fun IdleFactView(fact: UselessFact?) {
    if (fact != null) {
        Card(
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = fact.text,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.padding(24.dp),
                textAlign = TextAlign.Center
            )
        }
    } else {
        Text(
            text = "No fact available.",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(24.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FactScreenIdlePreview() {
    FactScreen(
        state = FactUiState.Idle(UselessFact("Did you know? Honey never spoils.")),
        onRequestNextFact = {}
    )
}

@Preview(showBackground = true)
@Composable
fun FactScreenIdleNoFactPreview() {
    FactScreen(
        state = FactUiState.Idle(null),
        onRequestNextFact = {}
    )
}

@Preview(showBackground = true)
@Composable
fun FactScreenLoadingPreview() {
    FactScreen(
        state = FactUiState.Loading,
        onRequestNextFact = {}
    )
}

@Preview(showBackground = true)
@Composable
fun FactScreenErrorPreview() {
    FactScreen(
        state = FactUiState.Error("Network error!"),
        onRequestNextFact = {}
    )
}
