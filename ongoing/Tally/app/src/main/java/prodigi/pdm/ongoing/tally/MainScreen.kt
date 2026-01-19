package prodigi.pdm.ongoing.tally

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import prodigi.pdm.ongoing.tally.domain.TallyCounter
import prodigi.pdm.ongoing.tally.domain.isAtCapacity
import prodigi.pdm.ongoing.tally.domain.isAtMinimum
import prodigi.pdm.ongoing.tally.ui.theme.TallyTheme


/**
 * The main screen possible states
 */
sealed interface MainScreenState {
    data class AtMin(val counter: TallyCounter): MainScreenState
    data class Counting(val counter: TallyCounter): MainScreenState
    data class AtCapacity(val counter: TallyCounter): MainScreenState
}

/**
 * The main screen of the app.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    TallyTheme {
        Scaffold(
            topBar = { TopAppBar(title = { Text(stringResource(R.string.app_name)) }) }
        ) { innerPadding ->
            var currentState: MainScreenState by remember {
                mutableStateOf(value = MainScreenState.AtMin(TallyCounter(count = 0)))
            }

            when (val state = currentState) {
                is MainScreenState.AtMin ->
                    TallyAtMinView(
                        counter = state.counter,
                        onIncrement = {
                            currentState = MainScreenState.Counting(TallyCounter(count = state.counter.count + 1))
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                is MainScreenState.Counting ->
                    TallyCountingView(
                        counter = state.counter,
                        onIncrement = {
                            val newCounter = TallyCounter(count = state.counter.count + 1)
                            currentState =
                                if (newCounter.isAtCapacity()) MainScreenState.AtCapacity(counter = newCounter)
                                else MainScreenState.Counting(counter = newCounter)
                        },
                        onDecrement = {
                            val newCounter = TallyCounter(count = state.counter.count - 1)
                            currentState =
                                if (newCounter.isAtMinimum()) MainScreenState.AtMin(counter = newCounter)
                                else MainScreenState.Counting(counter = newCounter)
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                is MainScreenState.AtCapacity ->
                    TallyAtCapacityView(
                        counter = state.counter,
                        onDecrement = {
                            currentState = MainScreenState.Counting(TallyCounter(count = state.counter.count - 1))
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}